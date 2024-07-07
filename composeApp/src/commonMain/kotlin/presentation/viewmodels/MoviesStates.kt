package presentation.viewmodels

import presentation.models.MovieDisplay

/**
 * Created by "Mohamad Abuzaid" on 08/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
data class PopularState(
    val loading: Boolean = false,
    val success: List<MovieDisplay>? = null,
    val error: String? = null
)