package di

import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
fun initKoinIos(
    appComponent: IosApplicationComponent
) {
    initKoin(
        additionalModules = listOf(module { single { appComponent } })
    )
}