import SwiftUI

@main
struct iOSApp: App {
    init() {
        KoinInit_iosKt.doInitKoinIos(
            appComponent: IosApplicationComponent()
        )
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}