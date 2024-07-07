package me.abuzaid.kmpmovies.base

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.os.LocaleList
import java.util.Locale

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class AppContextWrapper(base: Context?) : ContextWrapper(base) {

    companion object {
        fun wrap(context: Context, newLocale: Locale?): AppContextWrapper {
            val res = context.resources
            val configuration = Configuration(res.configuration)

            configuration.setLocale(newLocale)
            configuration.setLayoutDirection(newLocale)

            val localeList = LocaleList(newLocale)
            LocaleList.setDefault(localeList)
            configuration.setLocales(localeList)

            return AppContextWrapper(context.createConfigurationContext(configuration))
        }
    }
}