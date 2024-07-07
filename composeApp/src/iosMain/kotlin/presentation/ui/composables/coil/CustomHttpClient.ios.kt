package presentation.ui.composables.coil

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

/**
 * Created by "Mohamad Abuzaid" on 07/07/2024.
 * Email: mabuzaid@sure.com.sa
 */
actual fun createHttpClient(): HttpClient {
    return HttpClient(Darwin)
}