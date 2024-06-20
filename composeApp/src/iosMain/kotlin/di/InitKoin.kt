package di

import org.koin.core.context.startKoin

/**
 * Created by "Mohamad Abuzaid" on 18/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
fun initKoin() {
    // start Koin
    val koinApp = startKoin {
        modules(appModules())
    }.koin
}