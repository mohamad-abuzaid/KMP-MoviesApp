package me.abuzaid.kmpmovies.di

import me.abuzaid.movies.domain.usecases.MoviesUseCases
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
val useCasesModule = module {
    factory {
        MoviesUseCases(
            moviesRepository = get(),
            dispatcher = get(named("defaultDispatcher"))
        )
    }
}