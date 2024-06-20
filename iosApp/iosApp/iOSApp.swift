import SwiftUI

@main
struct iOSApp: App {
    init() {
        InitKoin.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}