package presentation.ui.composables.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch
import presentation.ui.utils.pullrefresh.PullRefreshIndicator
import presentation.ui.utils.pullrefresh.pullRefresh
import presentation.ui.utils.pullrefresh.rememberPullRefreshState
import presentation.ui.theme.PageBottom
import presentation.ui.theme.PageHorizontal
import presentation.ui.theme.PageTop

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Composable
fun ScreenPage(
    modifier: Modifier = Modifier,
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = PageTop, bottom = PageBottom)
            .padding(horizontal = PageHorizontal)
            .pullRefresh(state = pullToRefreshState, enabled = pullRefreshEnabled),
    ) {
        content()

        PullRefreshIndicator(
            backgroundColor = Color.White,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(alignment = Alignment.TopCenter),
            refreshing = refreshing.value,
            state = pullToRefreshState,
        )
    }
}