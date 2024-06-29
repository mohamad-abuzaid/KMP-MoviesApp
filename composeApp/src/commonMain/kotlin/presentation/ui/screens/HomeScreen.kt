package presentation.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
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
import presentation.ui.composables.MovieItem
import presentation.ui.composables.inputfields.InputTextField
import presentation.ui.composables.pages.ScreenPage
import presentation.ui.utils.Dummy

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class HomeScreen : Screen {
    @Composable
    override fun Content() {
        HomeScreenContent()
    }
}

@Composable
private fun HomeScreenContent() {
    val searchQuery = remember { mutableStateOf("") }

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

            val items = Dummy.movies

            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(items.size) { index ->
                    MovieItem(movieItem = items[index])
                }
            }
        }
    }
}