package me.abuzaid.kmpmovies.data.network.factory

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import kotlinx.serialization.ExperimentalSerializationApi

/**
 * Created by "Mohamad Abuzaid" on 27/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
actual class PlatformHttpClient {
    @OptIn(ExperimentalSerializationApi::class)
    actual fun create(
        baseUrl: String,
        token: String
    ) = HttpClient(Darwin) {
        setupJson(baseUrl, token)
    }
}