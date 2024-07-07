package me.abuzaid.kmpmovies.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
val miscModule = module {
    single(named("defaultDispatcher")) { Dispatchers.Default }
}