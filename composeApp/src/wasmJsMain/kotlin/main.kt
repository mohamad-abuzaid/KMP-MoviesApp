import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import di.initKoinWasmJs
import presentation.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoinWasmJs(appComponent = JsApplicationComponent())

    CanvasBasedWindow(canvasElementId = "ComposeTarget") { App() }
}