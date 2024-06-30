import SwiftUI

@main
struct iOSApp: App {
    init() {
        KoinInit_iosKt.doInitKoinIos()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}