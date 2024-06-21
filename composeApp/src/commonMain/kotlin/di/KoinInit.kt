package di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

/**
 * Created by "Mohamad Abuzaid" on 20/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
fun initKoin(
    appDeclaration: KoinAppDeclaration = {},
) {
    startKoin {
        appDeclaration()
        modules(appModules())
    }.koin
}