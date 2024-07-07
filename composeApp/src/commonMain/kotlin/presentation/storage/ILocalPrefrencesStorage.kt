package presentation.storage

/**
* Created by "Mohamad Abuzaid" on 01/06/2024.
* Email: m.abuzaid.ali@gmail.com
*/
interface ILocalPreferencesStorage {
    fun putInt(key: String, value: Int)
    fun getInt(key: String, defaultValue: Int): Int
    fun putLong(key: String, value: Long)
    fun getLong(key: String, defaultValue: Long): Long
    fun putString(key: String, value: String)
    fun getString(key: String, defaultValue: String): String
    fun putBoolean(key: String, value: Boolean)
    fun getBoolean(key: String, defaultValue: Boolean): Boolean
}