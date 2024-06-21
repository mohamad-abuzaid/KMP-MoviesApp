package di

import org.koin.dsl.KoinAppDeclaration

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
fun initKoinAndroid(
    appDeclaration: KoinAppDeclaration = {},
) {
    initKoin(appDeclaration)
}