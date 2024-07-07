package presentation.localization

import android.content.Context
import android.content.Intent
import presentation.ui.utils.findActivity

/**
 * Created by "Mohamad Abuzaid" on 28/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object Localization {
    actual fun setLocale(context: Any?, locale: String) {
        val activity = (context as Context).findActivity()
        activity?.let {
            val intent = Intent(it, it::class.java)
            it.finish()
            it.startActivity(intent)
        }
    }
}