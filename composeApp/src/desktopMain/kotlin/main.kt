import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.appModules
import org.koin.core.context.startKoin
import presentation.App

fun main() = application {
    startKoin {
        modules(appModules())
    }.koin

    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP-Movies",
    ) {
        App()
    }
}