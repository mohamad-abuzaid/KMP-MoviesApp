package di

import IosApplicationComponent
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
fun initKoinIos(appComponent: IosApplicationComponent) {
    initKoin(listOf(module { single { appComponent } }))
}