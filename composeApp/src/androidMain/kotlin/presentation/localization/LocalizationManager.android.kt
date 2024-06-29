package presentation.localization

import android.content.Context
import org.koin.mp.KoinPlatform
import presentation.ui.utils.findActivity

/**
 * Created by "Mohamad Abuzaid" on 28/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
actual object Localization {
    actual fun setLocale(locale: String) {
        val context = KoinPlatform.getKoin().get<Context>()

        context.findActivity()?.finish()
        context.findActivity()?.intent?.let {
            context.findActivity()?.startActivity(it)
        }
    }
}