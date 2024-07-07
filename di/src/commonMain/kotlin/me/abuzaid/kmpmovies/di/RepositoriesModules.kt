package me.abuzaid.kmpmovies.di

import me.abuzaid.kmpmovies.data.network.repositories.MoviesRepositoryImpl
import me.abuzaid.kmpmovies.domain.repositories.MoviesRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
val repositoriesModule = module {
    single<MoviesRepository> {
        MoviesRepositoryImpl(
            moviesApiServices = get(),
            dispatcher = get(named("defaultDispatcher"))
        )
    }
}