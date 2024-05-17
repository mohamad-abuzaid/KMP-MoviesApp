package me.abuzaid.kmpmovies.di

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform