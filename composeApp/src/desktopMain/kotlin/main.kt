import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.initKoinDesktop
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import presentation.App

fun main() = application {
    Napier.base(DebugAntilog("Napier_Jvm"))

    initKoinDesktop(appComponent = JvmApplicationComponent())

    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP-Movies",
    ) {
        App()
    }
}