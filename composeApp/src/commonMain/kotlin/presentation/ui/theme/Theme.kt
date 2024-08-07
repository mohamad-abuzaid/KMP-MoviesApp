package presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import presentation.ui.utils.ChangeStatusBarColors


val DarkColorScheme = darkColorScheme(
    background = Background,
    primary = Color.White,
    secondary = Content,
    tertiary = Border,
    primaryContainer = Container
)

val LightColorScheme = lightColorScheme(
    background = Background,
    primary = Color.White,
    secondary = Content,
    tertiary = Border,
    primaryContainer = Container
)

@Composable
fun MoviesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    //dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    ChangeStatusBarColors(darkTheme)

    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = getTypography(),
        content = content
    )
}