package di

import org.koin.dsl.KoinAppDeclaration

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
fun initKoinAndroid(
    appDeclaration: KoinAppDeclaration = {},
) {
    initKoin(appDeclaration)
}