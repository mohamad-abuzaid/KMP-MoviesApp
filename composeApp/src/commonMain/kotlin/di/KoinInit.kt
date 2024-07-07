package di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

/**
 * Created by "Mohamad Abuzaid" on 20/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
fun initKoin(
    additionalModules: List<Module> = listOf(),
    appDeclaration: KoinAppDeclaration = {},
) {
    startKoin {
        appDeclaration()
        modules(
            appModules() +
                    additionalModules
        )
    }.koin
}