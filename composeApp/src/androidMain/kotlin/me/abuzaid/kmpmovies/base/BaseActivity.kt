package me.abuzaid.kmpmovies.base

import android.content.Context
import androidx.activity.ComponentActivity
import org.koin.android.ext.android.inject
import presentation.localization.LocalizationUtils
import presentation.storage.ILocalPreferencesStorage
import presentation.storage.Preference
import java.util.Locale

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
open class BaseActivity : ComponentActivity() {
    val prefs: ILocalPreferencesStorage by inject()

    override fun attachBaseContext(baseContext: Context) {
        val lang = prefs.getString(Preference.LANGUAGE_KEY, LocalizationUtils.AR)
        val initialLocale = Locale(lang, LocalizationUtils.country(lang))

        super.attachBaseContext(AppContextWrapper.wrap(baseContext, initialLocale))
    }
}