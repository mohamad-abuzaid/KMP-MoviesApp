package me.abuzaid.kmpmovies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import me.abuzaid.kmpmovies.data.database.converters.DataTypeConverter
import me.abuzaid.kmpmovies.data.database.daos.MoviesDAO
import me.abuzaid.kmpmovies.data.database.entities.MovieEntity

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Database(
    entities = [
        MovieEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moviesDAO(): MoviesDAO

    companion object {
        fun getInstance(
            builder: Builder<AppDatabase>
        ): AppDatabase {
            return builder
                .fallbackToDestructiveMigrationOnDowngrade(true)
                .setDriver(BundledSQLiteDriver())
                .setQueryCoroutineContext(Dispatchers.IO)
                .build()
        }
    }
}