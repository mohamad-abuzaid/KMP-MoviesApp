package di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

/**
 * Created by "Mohamad Abuzaid" on 20/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
fun initKoin(
    additionalModules: List<Module> = listOf(),
    appDeclaration: KoinAppDeclaration = {},
) {
    startKoin {
        appDeclaration()
        modules(
            additionalModules +
                    appModules() +
                    listOf(platformModule)
        )
    }.koin
}