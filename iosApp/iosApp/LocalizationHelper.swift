//
//  LocalizationHelper.swift
//  iosApp
//
//  Created by Mohamad Abuzaid on 28/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

@objc class LocalizationHelper: NSObject {
    @objc class func setLocale(locale: String) {
        UserDefaults.standard.set([locale], forKey: "AppleLanguages")
        UserDefaults.standard.synchronize()

        // Reload the root view controller to apply the new language
        if let window = UIApplication.shared.keyWindow {
            let rootViewController = window.rootViewController
            window.rootViewController = nil
            window.rootViewController = rootViewController
        }
    }
}
