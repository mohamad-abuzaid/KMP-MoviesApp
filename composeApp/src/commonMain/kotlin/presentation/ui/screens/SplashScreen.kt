package presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.splash_background
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.storage.ILocalPreferencesStorage
import presentation.storage.Preference
import presentation.ui.screens.platform_composables.LanguageSelectScreen

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class SplashScreen : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val prefs: ILocalPreferencesStorage? by inject()

        SplashScreenContent(prefs)
    }
}

@Composable
fun SplashScreenContent(prefs: ILocalPreferencesStorage?) {
    val navigator = LocalNavigator.currentOrThrow

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(Res.drawable.splash_background),
            contentDescription = "Splash Image",
            contentScale = ContentScale.FillBounds
        )
    }

    val firstTime = prefs?.getBoolean(Preference.FIRST_TIME_LAUNCH, true) ?: false

    LaunchedEffect(Unit) {
        delay(3000)
        if (firstTime) {
            navigator.push(LanguageSelectScreen())
        } else {
            navigator.push(HomeScreen())
        }
    }
}