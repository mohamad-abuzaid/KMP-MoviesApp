package presentation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.image_placeholder
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.models.ActorDisplay
import presentation.ui.utils.Dummy

/**
 * Created by "Mohamad Abuzaid" on 07/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Composable
fun ActorItem(
    actor: ActorDisplay
) {
    Box(
        modifier = Modifier.wrapContentHeight(),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .padding(start = 20.dp)
                .width(150.dp)
                .fillMaxHeight()
                .clip(shape = RoundedCornerShape(12.dp))
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(start = 50.dp, end = 10.dp)
                .padding(vertical = 10.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = actor.name,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Start,
                    maxLines = 1
                )

                Text(
                    text = actor.role,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Start
                )
            }
        }

        SubcomposeAsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = CircleShape
                ),
            model = actor.photo,
            contentScale = ContentScale.FillBounds,
            loading = { CircularProgressIndicator() },
            error = {
                Image(
                    painter = painterResource(Res.drawable.image_placeholder),
                    contentDescription = "Placeholder Image"
                )
            },
            contentDescription = "Movie Image",
        )
    }
}

@Preview
@Composable
fun PreviewActorItem() {
    ActorItem(
        actor = Dummy.actor1
    )
}