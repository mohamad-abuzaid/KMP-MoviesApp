package presentation.localization

import java.util.Locale

/**
 * Created by "Mohamad Abuzaid" on 28/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object Localization {
     actual fun setLocale(locale: String) {
         val newLocale = Locale(locale)
         Locale.setDefault(newLocale)
        // You may need to reload resources or refresh UI if needed
    }
}
