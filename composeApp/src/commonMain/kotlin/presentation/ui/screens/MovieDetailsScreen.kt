package presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.util.DebugLogger
import io.ktor.http.decodeURLPart
import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.image_placeholder
import kmp_movies.composeapp.generated.resources.votes_number
import kmp_movies.composeapp.generated.resources.watch_now
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform
import presentation.models.MovieDisplay
import presentation.ui.composables.ActorItem
import presentation.ui.composables.RatingStars
import presentation.ui.composables.buttons.MainRoundedButton
import presentation.ui.composables.coil.createCustomHttpClient
import presentation.ui.composables.coil.createCustomImageLoader
import presentation.ui.composables.pages.ScreenPage
import presentation.ui.utils.Dummy

/**
 * Created by "Mohamad Abuzaid" on 07/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class MovieDetailsScreen(val movie: MovieDisplay) : Screen {
    @Composable
    override fun Content() {
        MovieDetailsScreenContent(movie)
    }
}

@Composable
fun MovieDetailsScreenContent(
    movie: MovieDisplay
) {
    val navigator = LocalNavigator.currentOrThrow

    ScreenPage(
        onBack = { navigator.pop() },
        pullRefreshEnabled = false,
        onRefresh = { }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            val token = KoinPlatform.getKoin().get<String>(named("accessToken"))
            val imageLoader = createCustomImageLoader(
                LocalPlatformContext.current,
                createCustomHttpClient(token)
            )

            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data("https://image.tmdb.org/t/p/original${movie.posterPath}")
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

            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            modifier = Modifier.weight(4f),
                            text = movie.title,
                            style = MaterialTheme.typography.displayLarge,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            modifier = Modifier.weight(1f),
                            text = movie.releaseDate.split("-")[0],
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RatingStars(rate = movie.voteAverage)

                        Text(
                            text = stringResource(Res.string.votes_number, movie.voteCount),
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.secondary,
                    lineHeight = 25.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                val actors = Dummy.actors
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(25.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(actors) { actor ->
                        ActorItem(actor = actor)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                MainRoundedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    text = stringResource(Res.string.watch_now)
                ) {}
                Spacer(modifier = Modifier.height(25.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewMovieDetailsScreen() {
    MovieDetailsScreen(
        movie = Dummy.movie1
    )
}