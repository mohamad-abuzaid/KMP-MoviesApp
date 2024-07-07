//
//  AppDelegate.swift
//  iosApp
//
//  Created by Mohamad Abuzaid on 28/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import ComposeApp

class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        #if DEBUG
        NapierProxyKt.debugBuild()
        #endif

        let commonAppDelegate = CommonAppDelegateImpl()
        commonAppDelegate.onCreate()
        
        return true
    }
    
    func applicationWillTerminate(_ application: UIApplication) {
        let commonAppDelegate = CommonAppDelegateImpl()
        commonAppDelegate.onTerminate()
    }
}
