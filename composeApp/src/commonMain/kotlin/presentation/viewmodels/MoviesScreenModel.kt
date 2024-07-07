package presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.abuzaid.movies.domain.usecases.MoviesUseCases
import presentation.models.mappers.toMovieDisplayList

/**
 * Created by "Mohamad Abuzaid" on 08/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class MoviesScreenModel(
    private val moviesUseCases: MoviesUseCases
) : ScreenModel {

    var popularState by mutableStateOf(PopularState())
        private set

    fun onEvent(event: MoviesEvents) {
        when (event) {
            is MoviesEvents.FetchPopular -> fetchPopularMovies(event.lang)
        }
    }

    private var fetchPopularJob: Job? = null
    private fun fetchPopularMovies(lang: String) {
        fetchPopularJob = screenModelScope.launch {
            popularState = popularState.copy(loading = true)
            try {
                moviesUseCases.fetchPopularMovies(lang).collect { result ->
                    popularState = if (result.error == null) {
                        popularState.copy(
                            success = result.value?.toMovieDisplayList(),
                            loading = false
                        )
                    } else {
                        popularState.copy(
                            error = result.error?.errorModel?.errorMessage,
                            loading = false
                        )
                    }
                }
            } catch (ioe: IOException) {
                popularState = popularState.copy(
                    error = "Unknown Error",
                    loading = false
                )
            }
        }
    }
}