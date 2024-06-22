package me.abuzaid.kmpmovies.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
actual class DatabaseBuilder {
    actual fun databaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        val dbFile = File(System.getProperty("java.io.tmpdir"), "movies_database.db")
        return Room.databaseBuilder<AppDatabase>(
            name = dbFile.absolutePath,
        )
    }
}