package di

import JvmApplicationComponent
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
fun initKoinDesktop(appComponent: JvmApplicationComponent) {
    initKoin(listOf(module { single { appComponent } }))
}