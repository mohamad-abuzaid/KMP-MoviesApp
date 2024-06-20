package me.abuzaid.kmpmovies

import android.app.Application
import di.initKoinAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import timber.log.Timber

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class MainApplication : Application() {

    override fun onCreate() {
        Timber.d("onCreate()")
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
            // Log Timber into Android logger - only if debug mode
            Timber.plant(Timber.DebugTree())
        }
    }
}