package me.abuzaid.kmpmovies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
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
}