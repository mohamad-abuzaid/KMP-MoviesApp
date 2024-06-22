package me.abuzaid.kmpmovies.di

import me.abuzaid.kmpmovies.data.database.AppDatabase
import me.abuzaid.kmpmovies.data.database.DatabaseBuilder
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
val commonDatabaseModule = module {
    single { DatabaseBuilder().databaseBuilder() }

    single { get<AppDatabase>().moviesDAO() }
}