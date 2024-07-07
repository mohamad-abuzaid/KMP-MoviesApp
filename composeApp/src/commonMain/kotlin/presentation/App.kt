package presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.ui.screens.SplashScreen
import presentation.ui.theme.MoviesTheme

@Composable
@Preview
fun App() {
    MoviesTheme {
        Navigator(screen = SplashScreen())
    }
}