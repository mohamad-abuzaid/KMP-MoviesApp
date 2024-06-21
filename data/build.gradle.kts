import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
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
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "data"
        browser {
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                    }
                }
            }
        }
        binaries.executable()
    }

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

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    applyDefaultHierarchyTemplate {
        // create a new group that
        // depends on `common`
        common {
            // Define group name without
            // `Main` as suffix
            group("nonJs") {
                // Provide which targets would
                // be part of this group
                withAndroidTarget()
                withIos()
                withJvm()
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":domain"))

            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.content.negotiation)
        }

        val nonJsMain by getting {
            dependencies {
                api(libs.room.runtime)
                implementation(libs.sqlite.bundled)
            }
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.android)
            implementation(libs.ktor.client.okhttp)

            implementation(libs.paging.room)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        val desktopMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }

        wasmJsMain.dependencies {
            implementation(libs.ktor.client.js)
        }
    }

    task("testClasses")
}

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    add("kspCommonMainMetadata", libs.room.compiler)
    add("kspAndroid", libs.room.compiler)
    add("kspDesktop", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosX64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
}