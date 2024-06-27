package presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.axiforma_bold
import kmp_movies.composeapp.generated.resources.axiforma_regular
import kmp_movies.composeapp.generated.resources.axiforma_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun getTypography(): Typography {

    val axiforma = FontFamily(
        Font(Res.font.axiforma_bold, weight = FontWeight.Bold),
        Font(Res.font.axiforma_semibold, weight = FontWeight.SemiBold),
        Font(Res.font.axiforma_regular, weight = FontWeight.Normal)
    )

    return Typography(
        bodyLarge = TextStyle(
            fontFamily = axiforma,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        )
    )
}