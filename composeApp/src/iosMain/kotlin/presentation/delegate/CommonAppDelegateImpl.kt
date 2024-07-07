package presentation.delegate

/**
 * Created by "Mohamad Abuzaid" on 07/07/2024.
 * Email: mabuzaid@sure.com.sa
 */
class CommonAppDelegateImpl : CommonAppDelegate {
    override fun onCreate() {
        println("App is created")
    }

    override fun onTerminate() {
        println("App is terminated")
    }
}