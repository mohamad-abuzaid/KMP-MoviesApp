package di

import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
fun initKoinWasmJs(
    appComponent: WasmJsApplicationComponent
) {
    initKoin(
        additionalModules = listOf(module { single { appComponent } })
    )
}