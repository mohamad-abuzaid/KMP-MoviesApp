package di

import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
fun initKoinAndroid(
    appComponent: AndroidApplicationComponent,
    appDeclaration: KoinAppDeclaration = {},
) {
    initKoin(
        additionalModules = listOf(module { single { appComponent } }),
        appDeclaration = appDeclaration)
}