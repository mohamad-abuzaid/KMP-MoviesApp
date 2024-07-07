//
//  LocalizationHelper.swift
//  iosApp
//
//  Created by Mohamad Abuzaid on 06/07/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import Foundation
import ComposeApp

public class LocalizationHelper: ILocal {

    public func setLocale(locale: String) {
        UserDefaults.standard.set([locale], forKey: "AppleLanguages")
        UserDefaults.standard.synchronize()

        //Reload the root view controller to apply the new language
        if let window = UIApplication.shared.keyWindow {
            let rootViewController = window.rootViewController
            window.rootViewController = nil
            window.rootViewController = rootViewController
        }
    }
}
