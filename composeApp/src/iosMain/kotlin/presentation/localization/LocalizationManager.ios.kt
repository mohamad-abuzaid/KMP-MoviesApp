package presentation.localization

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by "Mohamad Abuzaid" on 28/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
@OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object Localization : KoinComponent {
    actual fun setLocale(context: Any?, locale: String) {
        val localManager: ILocal by inject<ILocal>()
        localManager.setLocale(locale)
    }
}
