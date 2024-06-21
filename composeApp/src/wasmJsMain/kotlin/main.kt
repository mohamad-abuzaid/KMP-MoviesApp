import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import di.initKoinWasmJs
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import presentation.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    Napier.base(DebugAntilog("Napier_WasmJs"))

    initKoinWasmJs(appComponent = JsApplicationComponent())

    CanvasBasedWindow(canvasElementId = "ComposeTarget") { App() }
}