package me.abuzaid.kmpmovies.data.network.repositories

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.abuzaid.kmpmovies.data.network.models.mappers.toMovieModelList
import me.abuzaid.kmpmovies.data.network.services.ApiServices
import me.abuzaid.kmpmovies.domain.models.MovieModel
import me.abuzaid.kmpmovies.domain.models.wrappers.CallFailure
import me.abuzaid.kmpmovies.domain.models.wrappers.ErrorModel
import me.abuzaid.kmpmovies.domain.models.wrappers.NetworkCallResult
import me.abuzaid.kmpmovies.domain.repositories.MoviesRepository

/**
 * Created by "Mohamad Abuzaid" on 08/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class MoviesRepositoryImpl(
    private val moviesApiServices: ApiServices,
    private val dispatcher: CoroutineDispatcher
) : MoviesRepository {
    override suspend fun fetchPopularMovies(lang: String) =
        flow<NetworkCallResult<List<MovieModel>, CallFailure>> {
            val result = moviesApiServices.fetchPopularMovies(lang)

            result.results?.let {
                emit(NetworkCallResult(value = it.toMovieModelList()))
            } ?: run {
                emit(
                    NetworkCallResult(
                        error = CallFailure(
                            ErrorModel(
                                code = result.statusCode ?: -1,
                                errorMessage = result.statusMessage ?: ""
                            )
                        )
                    )
                )
            }

        }.flowOn(dispatcher)
            .catch { e ->
                emit(
                    NetworkCallResult(
                        error = CallFailure(
                            ErrorModel(
                                code = -1,
                                errorMessage = e.message ?: ""
                            )
                        )
                    )
                )
            }
}