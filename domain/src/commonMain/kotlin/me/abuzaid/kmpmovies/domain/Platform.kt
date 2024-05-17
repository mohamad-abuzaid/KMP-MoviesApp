package me.abuzaid.kmpmovies.domain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform