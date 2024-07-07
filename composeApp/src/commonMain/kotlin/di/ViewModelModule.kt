package di

import org.koin.dsl.module
import presentation.viewmodels.MoviesScreenModel

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */

val viewModelsModule = module {
    factory { MoviesScreenModel(get()) }
}