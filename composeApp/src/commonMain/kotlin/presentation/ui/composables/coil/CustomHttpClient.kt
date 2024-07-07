package presentation.ui.composables.coil

import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers

/**
 * Created by "Mohamad Abuzaid" on 07/07/2024.
 * Email: mabuzaid@sure.com.sa
 */
expect fun createHttpClient(): HttpClient

fun createCustomHttpClient(authToken: String): HttpClient {
    return createHttpClient().config {
        defaultRequest {
            headers {
                append("Authorization", "Bearer $authToken")
            }
        }
    }
}