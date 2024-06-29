package presentation.localization

/**
 * Created by "Mohamad Abuzaid" on 28/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object Localization {
    actual fun setLocale(context: Any?, locale: String) {
        LocalizationHelper.setLocale(locale)
    }
}
