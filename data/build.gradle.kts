import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

////////////////////////////////////////////////////////////////////////////////////////////////////
// Config                                                                                         //
////////////////////////////////////////////////////////////////////////////////////////////////////
class BConfig {
    var commonProperties: Properties = Properties()
}

////////////////////////////////////////////////////////////////////////////////////////////////////
// Pull in config properties                                                                      //
////////////////////////////////////////////////////////////////////////////////////////////////////

val config = BConfig()
val basePath = "${rootDir.absolutePath}/config/"

config.commonProperties.load(FileInputStream(rootProject.file("${basePath}common.properties")))

android {
    namespace = "me.abuzaid.kmpmovies.data"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        all {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"${config.commonProperties["base_url"]}\"")
            buildConfigField("String", "API_KEY", "\"${config.commonProperties["api"]}\"")
            buildConfigField("String", "TOKEN", "\"${config.commonProperties["token"]}\"")
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "data"
            isStatic = true
        }
    }
    jvm("desktop")

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":domain"))

                api(libs.ktor.client.core)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.client.contentNegotiation)

                api(libs.room.runtime)
                implementation(libs.sqlite.bundled)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.android)
                implementation(libs.ktor.client.okhttp)

                implementation(libs.paging.room)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }

        val commonTest by getting {
            dependencies {
            }
        }

        val androidUnitTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(libs.junit.test)
            }
        }
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosX64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
}
