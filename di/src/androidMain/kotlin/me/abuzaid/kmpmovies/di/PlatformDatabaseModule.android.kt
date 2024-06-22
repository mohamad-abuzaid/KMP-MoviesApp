package me.abuzaid.kmpmovies.di

import me.abuzaid.kmpmovies.data.database.AppDatabase
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
actual val platformDatabaseModule = module {
    single { AppDatabase.getInstance(builder = get()) }
}