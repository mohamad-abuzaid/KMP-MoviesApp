package presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.language_subtitle_ar
import kmp_movies.composeapp.generated.resources.language_subtitle_en
import kmp_movies.composeapp.generated.resources.language_title
import kmp_movies.composeapp.generated.resources.save
import org.jetbrains.compose.resources.stringResource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.localization.Localization
import presentation.localization.LocalizationUtils
import presentation.storage.ILocalPreferencesStorage
import presentation.storage.Preference
import presentation.ui.composables.buttons.MainRoundedButton
import presentation.ui.composables.buttons.RadioButtonStroke
import presentation.ui.composables.pages.ScreenPage

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Composable
fun LanguageSelectScreenContent(
    context: Any?,
    prefs: ILocalPreferencesStorage?
) {
    val navigator = LocalNavigator.currentOrThrow

    val initialLangCode =
        prefs?.getString(Preference.LANGUAGE_KEY, LocalizationUtils.AR) ?: LocalizationUtils.AR
    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(LocalizationUtils.lang(initialLangCode))
    }

    if (LocalizationUtils.code(selectedOption) != initialLangCode) {
        val code = LocalizationUtils.code(selectedOption)
        prefs?.putString(Preference.LANGUAGE_KEY, code)

        Localization.setLocale(context, code)
    }

    ScreenPage(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background),
        onRefresh = { }
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.weight(1f))
            Text(
                stringResource(Res.string.language_title),
                style = MaterialTheme.typography.displayLarge,
                color = Color.White
            )

            Spacer(Modifier.height(25.dp))
            Text(
                stringResource(Res.string.language_subtitle_ar),
                style = MaterialTheme.typography.displayMedium,
                color = Color.White
            )

            Spacer(Modifier.height(10.dp))
            Text(
                stringResource(Res.string.language_subtitle_en),
                style = MaterialTheme.typography.displayMedium,
                color = Color.White
            )

            Spacer(Modifier.weight(1f))
            LocalizationUtils.langOptions.forEach { text ->
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    RadioButtonStroke(
                        text = text,
                        iconRes = LocalizationUtils.icon(text),
                        selectedOption = selectedOption,
                        onOptionSelected = onOptionSelected
                    )
                }
            }

            Spacer(Modifier.weight(1f))
            MainRoundedButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(Res.string.save)
            ) {
                prefs?.putBoolean(Preference.FIRST_TIME_LAUNCH, false)
                //navigator.push(HomeScreen())
            }
        }
    }
}