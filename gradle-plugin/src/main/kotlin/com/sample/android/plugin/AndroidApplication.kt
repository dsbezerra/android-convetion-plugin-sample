package com.sample.android.plugin

import PluginConstants.APPLICATION_COMPONENT_NAME
import PluginConstants.COMPILE_SDK
import PluginConstants.MIN_SDK
import PluginConstants.TARGET_SDK
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureApplication() {
    configure<ApplicationExtension> {
        defaultConfig {
            compileSdk = COMPILE_SDK
            minSdk = MIN_SDK
            targetSdk = TARGET_SDK

            vectorDrawables.useSupportLibrary = true

            testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

            renderscriptTargetApi = COMPILE_SDK
            renderscriptSupportModeEnabled = true
        }

        publishing {
            singleVariant(APPLICATION_COMPONENT_NAME) {
                publishApk()
            }
        }

        configureCommonAndroid(this)
    }
}