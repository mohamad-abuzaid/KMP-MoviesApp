package presentation.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.copy
import platform.CoreGraphics.CGRectMake
import platform.UIKit.UIApplication
import platform.UIKit.UIColor
import platform.UIKit.UIView
import platform.UIKit.UIWindow
import presentation.ui.theme.DarkColorScheme
import presentation.ui.theme.LightColorScheme

/**
 * Created by "Mohamad Abuzaid" on 27/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun ChangeStatusBarColors(darkTheme: Boolean) {
    val safeFrameSize = remember { mutableStateOf(0.0) }
    val window = (UIApplication.sharedApplication.windows.first() as UIWindow)
    // Getting safe area size
    window.safeAreaLayoutGuide.layoutFrame.copy {
        // Getting safe area size in case of landscape and portrait
        safeFrameSize.value = origin.y

    }
    val statusBar = UIView(
        frame = CGRectMake(
            x = 0.0, y = 0.0, width = Double.MAX_VALUE, height = safeFrameSize.value
        )
    )
    statusBar.backgroundColor =
        if (darkTheme) DarkColorScheme.background.toUIColor() else LightColorScheme.background.toUIColor()

    SideEffect {
        UIApplication.sharedApplication.keyWindow?.addSubview(statusBar)
    }
}

fun Color.toUIColor(): UIColor {
    return UIColor(
        red = red.toDouble(),
        green = green.toDouble(),
        blue = blue.toDouble(),
        alpha = alpha.toDouble()
    )
}