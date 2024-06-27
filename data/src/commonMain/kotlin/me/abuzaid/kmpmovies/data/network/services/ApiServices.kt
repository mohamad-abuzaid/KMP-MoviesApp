package me.abuzaid.kmpmovies.data.network.services

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import me.abuzaid.movies.data.network.models.MovieRemote
import me.abuzaid.kmpmovies.data.network.models.wrappers.RemoteResponse

/**
 * Created by "Mohamad Abuzaid" on 26/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class ApiServices(private val client: HttpClient) {

    companion object {
        private const val FETCH_MOVIES = "discover/movie"
    }

    suspend fun fetchMovies(): RemoteResponse<List<MovieRemote>> = client.get(FETCH_MOVIES).body()
}