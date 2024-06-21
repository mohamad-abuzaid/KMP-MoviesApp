import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.initKoinDesktop
import presentation.App

fun main() = application {
    initKoinDesktop(appComponent = JvmApplicationComponent())

    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP-Movies",
    ) {
        App()
    }
}