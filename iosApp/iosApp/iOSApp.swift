import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        KoinInit_iosKt.doInitKoinIos(modules(appModules())LocalizationHelper())
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
