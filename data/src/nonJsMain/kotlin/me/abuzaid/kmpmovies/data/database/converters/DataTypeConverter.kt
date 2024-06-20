package me.abuzaid.kmpmovies.data.database.converters

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import timber.log.Timber

/**
 * Created by "Mohamad Abuzaid" on 25/05/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class DataTypeConverter {

    @TypeConverter
    fun fromIntList(value: List<Int>?): String {
        return value?.let { Json.encodeToString(it) } ?: ""
    }

    @TypeConverter
    fun toIntList(value: String): List<Int>? {

        return try {
            Json.decodeFromString(value)
        } catch (ex: Exception) {
            Timber.tag("DataTypeConverter").e(ex)
            null
        }
    }

    /*************************/
    /*************************/

    @TypeConverter
    fun fromMap(value: Map<String, String>?): String {
        return value?.let { Json.encodeToString(it) } ?: ""
    }

    @TypeConverter
    fun toMap(value: String): Map<String, String>? {

        return try {
            Json.decodeFromString(value)
        } catch (ex: Exception) {
            Timber.tag("DataTypeConverter").e(ex)
            null
        }
    }
}