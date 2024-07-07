package presentation.ui.composables.coil

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.network.CacheStrategy
import coil3.network.NetworkFetcher
import coil3.network.ktor.asNetworkClient
import coil3.request.CachePolicy
import io.ktor.client.HttpClient
import kotlin.jvm.JvmName

/**
 * Created by "Mohamad Abuzaid" on 07/07/2024.
 * Email: mabuzaid@sure.com.sa
 */
@OptIn(ExperimentalCoilApi::class)
@JvmName("factory")
fun ktorNetworkFetcherFactory(
    httpClient: HttpClient
) = NetworkFetcher.Factory(
    networkClient = { httpClient.asNetworkClient() },
    cacheStrategy = { CacheStrategy() },
)

fun createCustomImageLoader(
    context: PlatformContext,
    httpClient: HttpClient
): ImageLoader {
    return ImageLoader.Builder(context)
        .components {
            add(ktorNetworkFetcherFactory(httpClient))
        }
        .networkCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.DISABLED)
        .build()
}