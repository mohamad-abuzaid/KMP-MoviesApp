package me.abuzaid.movies.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import me.abuzaid.kmpmovies.domain.repositories.MoviesRepository

/**
 * Created by "Mohamad Abuzaid" on 08/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class MoviesUseCases(
    private val moviesRepository: MoviesRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend fun fetchPopularMovies(lang: String) =
        withContext(dispatcher) {
            moviesRepository.fetchPopularMovies(lang)
        }
}