package me.abuzaid.kmpmovies.di

import me.abuzaid.kmpmovies.data.network.di.networkModule
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
val servicesModule = module {
    includes(networkModule)

//    single<MoviesApiService> { get<Ktor>().create(MoviesApiService::class.java) }
}