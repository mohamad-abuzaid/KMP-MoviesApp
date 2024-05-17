package me.abuzaid.kmpmovies.data

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform