package presentation.localization

/**
 * Created by "Mohamad Abuzaid" on 28/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
actual object Localization {
    actual fun setLocale(locale: String) {
        LocalizationHelper.setLocale(locale)
    }
}
