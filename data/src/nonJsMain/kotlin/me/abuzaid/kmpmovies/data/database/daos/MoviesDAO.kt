package me.abuzaid.kmpmovies.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import me.abuzaid.kmpmovies.data.database.entities.MovieEntity

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Dao
interface MoviesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(languages: List<MovieEntity>): List<Long>

    @Query("SELECT * FROM movies ORDER BY tId")
    fun getMovies(): Flow<List<MovieEntity>>
}