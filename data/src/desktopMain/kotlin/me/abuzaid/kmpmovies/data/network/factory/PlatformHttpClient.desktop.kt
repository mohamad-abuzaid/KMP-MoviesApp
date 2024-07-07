package me.abuzaid.kmpmovies.data.network.factory

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

/**
 * Created by "Mohamad Abuzaid" on 27/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class PlatformHttpClient {
    actual fun create(
        baseUrl: String,
        token: String
    ) = HttpClient(OkHttp) {
        setupJson(baseUrl, token)
    }
}