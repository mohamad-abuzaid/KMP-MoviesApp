package presentation.localization

import android.content.Context
import org.koin.core.component.KoinComponent
import presentation.ui.utils.findActivity

/**
 * Created by "Mohamad Abuzaid" on 28/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object Localization: KoinComponent {
    actual fun setLocale(context: Any?, locale: String) {
        (context as Context).findActivity()?.finish()
        context.findActivity()?.intent?.let {
            context.findActivity()?.startActivity(it)
        }
    }
}