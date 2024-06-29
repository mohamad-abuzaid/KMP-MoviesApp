package presentation.ui.screens.platform_composables

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.storage.ILocalPreferencesStorage
import presentation.ui.screens.LanguageSelectScreenContent

/**
 * Created by "Mohamad Abuzaid" on 29/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class LanguageSelectScreen : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val prefs: ILocalPreferencesStorage? by inject()

        LanguageSelectScreenContent(null, prefs)
    }
}