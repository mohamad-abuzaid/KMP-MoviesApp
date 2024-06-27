package presentation.storage

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
class PreferencesStorage constructor(private val settings: Settings) : ILocalPreferencesStorage {
    override fun putString(key: String, value: String) {
        settings[key] = value
    }

    override fun getString(key: String, defaultValue: String): String {
        return settings.getString(key, defaultValue)
    }

    override fun putInt(key: String, value: Int) {
        settings[key] = value
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return settings.getInt(key, defaultValue)
    }

    override fun putLong(key: String, value: Long) {
        settings[key] = value
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return settings.getLong(key, defaultValue)
    }

    override fun putBoolean(key: String, value: Boolean) {
        settings[key] = value
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return settings.getBoolean(key, defaultValue)
    }
}