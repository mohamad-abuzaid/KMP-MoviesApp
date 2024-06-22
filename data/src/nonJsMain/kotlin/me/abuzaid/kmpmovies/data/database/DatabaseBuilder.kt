package me.abuzaid.kmpmovies.data.database

import androidx.room.RoomDatabase

/**
 * Created by "Mohamad Abuzaid" on 21/06/2024.
 * Email: mabuzaid@sure.com.sa
 */
expect class DatabaseBuilder() {
    fun databaseBuilder(): RoomDatabase.Builder<AppDatabase>
}