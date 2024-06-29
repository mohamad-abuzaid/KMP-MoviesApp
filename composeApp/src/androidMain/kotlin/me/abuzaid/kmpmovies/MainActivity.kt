package me.abuzaid.kmpmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import me.abuzaid.kmpmovies.base.BaseActivity
import org.koin.android.ext.android.inject
import presentation.App
import presentation.storage.ILocalPreferencesStorage
import presentation.storage.Preference
import presentation.ui.utils.LocalLang

class MainActivity : BaseActivity() {
    private val prefs: ILocalPreferencesStorage by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val lang = prefs.getString(Preference.LANGUAGE_KEY, "ar")

        setContent {
            CompositionLocalProvider(
                LocalLang provides lang
            ) {
                App()
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}