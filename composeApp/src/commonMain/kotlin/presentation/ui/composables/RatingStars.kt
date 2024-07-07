package presentation.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.ic_half_star
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Created by "Mohamad Abuzaid" on 03/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Composable
fun RatingStars(
    rate: Double
) {
    Row {
        for (i in 1..5) {
            val icon = when {
                i <= rate -> Icons.Filled.Star
                i - 0.5 == rate -> vectorResource(Res.drawable.ic_half_star)
                else -> Icons.Outlined.Star
            }
            Icon(
                modifier = Modifier.padding(2.dp),
                imageVector = icon,
                contentDescription = "Star $i",
                tint = if (i <= rate || i - 0.5 == rate) Color.Yellow else Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun PreviewRatingStars() {
    RatingStars(rate = 3.5)
}