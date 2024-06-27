package me.abuzaid.kmpmovies.data.network.di

import io.ktor.client.HttpClient
import me.abuzaid.kmpmovies.data.BuildConfig
import me.abuzaid.kmpmovies.data.network.factory.PlatformHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
val networkModule = module {
    single(named("dataBaseUrl")) { BuildConfig.BASE_URL }
    single(named("accessToken")) { BuildConfig.TOKEN }

    single<HttpClient> {
        PlatformHttpClient().create(
            baseUrl = get(named("dataBaseUrl")),
            token = get(named("accessToken"))
        )
    }
}