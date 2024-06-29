package presentation.localization

import android.content.Context
import android.content.Intent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.ui.utils.findActivity

/**
 * Created by "Mohamad Abuzaid" on 28/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object Localization : KoinComponent {
    actual fun setLocale(locale: String) {
        val context: Context by inject()

//        context.findActivity()?.finish()
//        context.findActivity()?.intent?.let {
//            context.findActivity()?.startActivity(it)
//        }

        val activity = context.findActivity()
        activity?.let {
            val intent = Intent(it, it::class.java)
            it.finish()
            it.startActivity(intent)
        }
    }
}