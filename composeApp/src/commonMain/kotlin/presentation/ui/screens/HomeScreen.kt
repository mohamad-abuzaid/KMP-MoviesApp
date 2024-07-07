package presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.ktor.http.encodeURLParameter
import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.categories_title
import kmp_movies.composeapp.generated.resources.ic_movies
import kmp_movies.composeapp.generated.resources.ic_shows
import kmp_movies.composeapp.generated.resources.movies
import kmp_movies.composeapp.generated.resources.popular_title
import kmp_movies.composeapp.generated.resources.search_title
import kmp_movies.composeapp.generated.resources.shows
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import presentation.localization.LocalizationUtils
import presentation.ui.composables.MovieItem
import presentation.ui.composables.inputfields.InputTextField
import presentation.ui.composables.loaders.ErrorView
import presentation.ui.composables.loaders.LoadingIndicatorRotating
import presentation.ui.composables.loaders.NoContentView
import presentation.ui.composables.pages.ScreenPage
import presentation.ui.utils.LocalLang
import presentation.viewmodels.MoviesEvents
import presentation.viewmodels.MoviesScreenModel
import presentation.viewmodels.PopularState

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class HomeScreen : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = navigator.rememberNavigatorScreenModel { get<MoviesScreenModel>() }
        val state = screenModel.popularState
        val event = screenModel::onEvent

        HomeScreenContent(navigator, state, event)
    }
}

@Composable
private fun HomeScreenContent(
    navigator: Navigator,
    state: PopularState,
    fireEvent: (MoviesEvents) -> Unit
) {
    val lang = LocalLang.current
    val searchQuery = remember { mutableStateOf("") }

    /*****************************/

    LaunchedEffect(key1 = state) {
        if (state.success == null) {
            fireEvent(
                MoviesEvents.FetchPopular(LocalizationUtils.fullLocal(lang))
            )
        }
    }
    /*****************************/

    ScreenPage(
        pullRefreshEnabled = true,
        onRefresh = { }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                text = stringResource(Res.string.search_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            InputTextField(
                placeholder = stringResource(Res.string.search_title)
            ) {
                searchQuery.value = it
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(Res.string.categories_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Image(
                        modifier = Modifier.width(180.dp),
                        painter = painterResource(Res.drawable.ic_movies),
                        contentDescription = "Movies Image"
                    )

                    Text(
                        modifier = Modifier.padding(top = 25.dp, end = 10.dp),
                        text = stringResource(Res.string.movies),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Image(
                        modifier = Modifier.width(175.dp),
                        painter = painterResource(Res.drawable.ic_shows),
                        contentDescription = "Movies Image"
                    )

                    Text(
                        modifier = Modifier.padding(top = 25.dp, start = 10.dp),
                        text = stringResource(Res.string.shows),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(Res.string.popular_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            with(state) {
                this.success?.let { movies ->
                    if (movies.isNotEmpty()) {
                        LazyVerticalGrid(
                            modifier = Modifier.fillMaxSize(),
                            columns = GridCells.Fixed(3),
                            contentPadding = PaddingValues(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            items(movies) { movie ->
                                MovieItem(
                                    movieItem = movie
                                ) {
                                    navigator.push(
                                        MovieDetailsScreen(
                                            movie.copy(
                                                backdropPath = movie.backdropPath.encodeURLParameter(),
                                                posterPath = movie.posterPath.encodeURLParameter()
                                            )
                                        )
                                    )
                                }
                            }
                        }
                    } else {
                        NoContentView()
                    }
                }

                this.error?.let { error ->
                    ErrorView(errorText = error) {
                        fireEvent(
                            MoviesEvents.FetchPopular(LocalizationUtils.fullLocal(lang))
                        )
                    }
                }

                if (this.loading) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Unspecified)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        LoadingIndicatorRotating(false)
                    }
                }
            }
        }
    }
}