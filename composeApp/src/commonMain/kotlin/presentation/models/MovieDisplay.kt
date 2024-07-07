package presentation.models

import kotlinx.serialization.Serializable

/**
 * Created by "Mohamad Abuzaid" on 05/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
@Serializable
data class MovieDisplay(
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)