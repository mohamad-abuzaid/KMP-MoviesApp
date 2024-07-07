package di

import com.russhwolf.settings.Settings
import org.koin.dsl.module
import presentation.storage.ILocalPreferencesStorage
import presentation.storage.PreferencesStorage

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */

val storageModule = module {
    single<ILocalPreferencesStorage> { PreferencesStorage(settings = Settings()) }
}