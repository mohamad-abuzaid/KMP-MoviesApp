package presentation.ui.utils

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import presentation.ui.theme.DarkColorScheme
import presentation.ui.theme.LightColorScheme

/**
 * Created by "Mohamad Abuzaid" on 27/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
@Composable
actual fun ChangeStatusBarColors(darkTheme: Boolean) {
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor =
                if (darkTheme) DarkColorScheme.background.toArgb() else LightColorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }
}