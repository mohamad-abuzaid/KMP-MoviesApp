package me.abuzaid.kmpmovies.data.network.models.mappers

import me.abuzaid.movies.data.network.models.MovieRemote
import me.abuzaid.kmpmovies.domain.models.MovieModel

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
fun MovieRemote.toMovieModel() = MovieModel(
    id ?: -1,
    adult ?: false,
    backdropPath ?: "",
    genreIds ?: listOf(),
    originalLanguage ?: "",
    originalTitle ?: "",
    overview ?: "",
    popularity ?: 0.0,
    posterPath ?: "",
    releaseDate ?: "",
    title ?: "",
    video ?: false,
    voteAverage ?: 0.0,
    voteCount ?: -1
)

fun List<MovieRemote>.toMovieModelList() =
    map { it.toMovieModel() }