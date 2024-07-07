package presentation.viewmodels

/**
 * Created by "Mohamad Abuzaid" on 08/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
sealed class MoviesEvents {
    data class FetchPopular(val lang: String) : MoviesEvents()
}