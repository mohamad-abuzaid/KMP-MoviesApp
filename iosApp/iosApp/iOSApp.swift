import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate

    init() {
        KoinInit_iosKt.doInitKoinIos(
            appComponent: IosApplicationComponent(
                localManager: LocalizationHelper()
            )
        )
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
