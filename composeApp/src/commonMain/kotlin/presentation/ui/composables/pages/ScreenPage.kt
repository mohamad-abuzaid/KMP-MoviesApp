package presentation.ui.composables.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.ic_arrow_left
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.ui.theme.Corner
import presentation.ui.theme.PageHorizontal
import presentation.ui.utils.pullrefresh.PullRefreshIndicator
import presentation.ui.utils.pullrefresh.pullRefresh
import presentation.ui.utils.pullrefresh.rememberPullRefreshState

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPage(
    modifier: Modifier = Modifier,
    onBack: (() -> Unit)? = null,
    pullRefreshEnabled: Boolean = false,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit
) {
    val refreshScope = rememberCoroutineScope()
    val refreshing = remember { mutableStateOf(false) }
    fun refresh() = refreshScope.launch {
        refreshing.value = true
        onRefresh()
        refreshing.value = false
    }

    val pullToRefreshState = rememberPullRefreshState(refreshing.value, ::refresh)

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 16.dp),
                title = {},
                navigationIcon = {
                    onBack?.let {
                        IconButton(
                            modifier = Modifier.size(15.dp),
                            onClick = { onBack() }
                        ) {
                            Icon(
                                imageVector = vectorResource(Res.drawable.ic_arrow_left),
                                tint = Color.White,
                                contentDescription = "Back button"
                            )
                        }
                    }
                },
                actions = {},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = PageHorizontal)
                .pullRefresh(state = pullToRefreshState, enabled = pullRefreshEnabled),
        ) {
            content()

            PullRefreshIndicator(
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter),
                backgroundColor = Color.White,
                contentColor = MaterialTheme.colorScheme.primary,
                refreshing = refreshing.value,
                state = pullToRefreshState,
            )
        }
    }
}

@Preview
@Composable
fun PreviewScreenPage() {
    ScreenPage(
        onBack = {},
        onRefresh = {},
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top
        ) {
            Card(
                shape = RoundedCornerShape(Corner),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray,
                ),
                modifier = Modifier
                    .height(20.dp)
                    .width(30.dp),
            ) {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = "Card Content",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}