package me.abuzaid.movies.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by "Mohamad Abuzaid" on 26/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Serializable
data class MovieRemote(
    @SerialName("id")
    val id: Int?,

    @SerialName("adult")
    val adult: Boolean?,

    @SerialName("backdrop_path")
    val backdropPath: String?,

    @SerialName("genre_ids")
    val genreIds: List<Int>?,

    @SerialName("original_language")
    val originalLanguage: String?,

    @SerialName("original_title")
    val originalTitle: String?,

    @SerialName("overview")
    val overview: String?,

    @SerialName("popularity")
    val popularity: Double?,

    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("release_date")
    val releaseDate: String?,

    @SerialName("title")
    val title: String?,

    @SerialName("video")
    val video: Boolean?,

    @SerialName("vote_average")
    val voteAverage: Double?,

    @SerialName("vote_count")
    val voteCount: Int?
)