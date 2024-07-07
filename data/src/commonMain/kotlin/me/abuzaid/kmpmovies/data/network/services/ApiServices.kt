package me.abuzaid.kmpmovies.data.network.services

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import me.abuzaid.movies.data.network.models.MovieRemote
import me.abuzaid.kmpmovies.data.network.models.wrappers.RemoteResponse

/**
 * Created by "Mohamad Abuzaid" on 26/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class ApiServices(private val client: HttpClient) {

    companion object {
        private const val FETCH_POPULAR_MOVIES = "discover/movie"
    }

    suspend fun fetchPopularMovies(lang: String): RemoteResponse<List<MovieRemote>> =
        client.get(FETCH_POPULAR_MOVIES) {
            parameter("include_adult", false)
            parameter("include_video", false)
            parameter("language", lang)
            parameter("page", 1)
            parameter("sort_by", "popularity.desc")
        }.body()
}