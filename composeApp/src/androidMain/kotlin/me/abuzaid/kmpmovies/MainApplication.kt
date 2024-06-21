package me.abuzaid.kmpmovies

import android.app.Application
import di.initKoinAndroid
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoinAndroid(
            appComponent = AndroidApplicationComponent()
        ) {
            // Log Koin into Android logger
            androidLogger()

            // Reference Android context
            androidContext(this@MainApplication)
        }

        if (BuildConfig.DEBUG) {
            Napier.base(DebugAntilog("Napier_Android"))
        }
    }
}