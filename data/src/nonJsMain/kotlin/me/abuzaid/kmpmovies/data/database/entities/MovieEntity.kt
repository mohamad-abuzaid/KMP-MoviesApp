package me.abuzaid.movies.data.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Entity(
    tableName = "movies",
    indices = [Index(value = ["id"], unique = true)]
)
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val tId: Long = 0,
    val id: String?,
    val name: String?
) : Serializable