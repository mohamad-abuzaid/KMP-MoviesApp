package presentation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.image_placeholder
import org.jetbrains.compose.resources.painterResource
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform
import presentation.models.MovieDisplay
import presentation.ui.composables.coil.createCustomHttpClient
import presentation.ui.composables.coil.createCustomImageLoader

/**
 * Created by "Mohamad Abuzaid" on 03/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Composable
fun MovieItem(
    movieItem: MovieDisplay,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(10.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val token = KoinPlatform.getKoin().get<String>(named("accessToken"))
        val imageLoader = createCustomImageLoader(
            LocalPlatformContext.current,
            createCustomHttpClient(token)
        )

        SubcomposeAsyncImage(
            modifier = Modifier
                .size(120.dp)
                .clip(shape = RoundedCornerShape(12.dp)),
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data("https://image.tmdb.org/t/p/original${movieItem.posterPath}")
                .build(),
            contentScale = ContentScale.FillBounds,
            imageLoader = imageLoader,
            loading = { CircularProgressIndicator() },
            error = {
                Image(
                    painter = painterResource(Res.drawable.image_placeholder),
                    contentDescription = "Placeholder Image"
                )
            },
            contentDescription = "Movie Image",
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = movieItem.title,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = movieItem.releaseDate.split("-")[0],
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}