//
//  AppDelegate.swift
//  iosApp
//
//  Created by Mohamad Abuzaid on 28/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        Napier.base(DebugAntilog("Napier_iOS"))
        return true
    }
}
