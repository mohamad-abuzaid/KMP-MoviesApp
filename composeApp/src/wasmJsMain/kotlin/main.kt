import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import di.appModules
import org.koin.core.context.startKoin
import presentation.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        modules(appModules())
    }.koin

    CanvasBasedWindow(canvasElementId = "ComposeTarget") { App() }
}