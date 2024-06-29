package me.abuzaid.kmpmovies

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import me.abuzaid.kmpmovies.base.BaseActivity
import presentation.App
import presentation.storage.Preference
import presentation.ui.utils.LocalLang

class MainActivity : BaseActivity() {

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