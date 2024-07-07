package me.abuzaid.kmpmovies.domain.repositories

import kotlinx.coroutines.flow.Flow
import me.abuzaid.kmpmovies.domain.models.MovieModel
import me.abuzaid.kmpmovies.domain.models.wrappers.CallFailure
import me.abuzaid.kmpmovies.domain.models.wrappers.NetworkCallResult

/**
 * Created by "Mohamad Abuzaid" on 08/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
interface MoviesRepository {
    suspend fun fetchPopularMovies(lang: String): Flow<NetworkCallResult<List<MovieModel>, CallFailure>>
}