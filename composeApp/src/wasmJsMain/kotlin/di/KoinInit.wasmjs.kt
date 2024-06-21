package di

import JsApplicationComponent
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
fun initKoinWasmJs(appComponent: JsApplicationComponent) {
    initKoin(listOf(module { single { appComponent } }))
}