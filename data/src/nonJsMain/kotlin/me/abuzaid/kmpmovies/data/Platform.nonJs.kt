package me.abuzaid.kmpmovies.data

class NonJsPlatform : Platform {
    override val name: String = "NonJs Platform"
}

actual fun getPlatform(): Platform = NonJsPlatform()