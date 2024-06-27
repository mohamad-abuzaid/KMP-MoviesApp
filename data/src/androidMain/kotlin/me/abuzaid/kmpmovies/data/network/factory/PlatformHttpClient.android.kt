package me.abuzaid.kmpmovies.data.network.factory

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

/**
 * Created by "Mohamad Abuzaid" on 27/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
actual class PlatformHttpClient {
    actual fun create(
        baseUrl: String,
        token: String
    ) = HttpClient(Android) {
        setupJson(baseUrl, token)
    }
}