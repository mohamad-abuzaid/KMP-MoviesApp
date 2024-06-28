package di

import me.abuzaid.kmpmovies.di.miscModule
import me.abuzaid.kmpmovies.di.repositoriesModule
import me.abuzaid.kmpmovies.di.servicesModule
import me.abuzaid.kmpmovies.di.useCasesModule

/**
 * Created by "Mohamad Abuzaid" on 18/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
fun appModules() = listOf(
    viewModelsModule,
    storageModule,
    useCasesModule,
    repositoriesModule,
    miscModule,
    servicesModule
)