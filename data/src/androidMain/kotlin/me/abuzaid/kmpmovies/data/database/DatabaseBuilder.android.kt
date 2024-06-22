package me.abuzaid.kmpmovies.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
actual class DatabaseBuilder : KoinComponent {
    actual fun databaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        val appContext: Context by inject()

        val dbFile = appContext.getDatabasePath("movies_database.db")
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}