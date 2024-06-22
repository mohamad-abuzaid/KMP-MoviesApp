package me.abuzaid.kmpmovies.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
// Make sure you eventually have this imported properly
// The package prefix should be the same as your database declared above
import me.abuzaid.kmpmovies.data.database.instantiateImpl
/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
actual class DatabaseBuilder {
    actual fun databaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        val dbFilePath = NSHomeDirectory() + "/movies_database.db"
        return Room.databaseBuilder<AppDatabase>(
            name = dbFilePath,
            factory = { AppDatabase::class.instantiateImpl() }
        )
    }
}
