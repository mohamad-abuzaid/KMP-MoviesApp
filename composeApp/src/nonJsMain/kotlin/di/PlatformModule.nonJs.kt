package di

import me.abuzaid.kmpmovies.di.commonDatabaseModule
import me.abuzaid.kmpmovies.di.platformDatabaseModule

/**
 * Created by "Mohamad Abuzaid" on 20/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
actual val platformModule = listOf(
    commonDatabaseModule,
    platformDatabaseModule
)