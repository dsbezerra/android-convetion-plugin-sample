package com.sample.android.plugin

import PluginConstants.COMPILE_SDK
import PluginConstants.LIBRARY_COMPONENT_NAME
import PluginConstants.MIN_SDK
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure


internal fun Project.configureLibrary() {
    configure<LibraryExtension> {
        defaultConfig {
            compileSdk = COMPILE_SDK
            minSdk = MIN_SDK

            vectorDrawables.useSupportLibrary = true

            testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        }

        publishing {
            singleVariant(LIBRARY_COMPONENT_NAME) {
                withSourcesJar()
                withJavadocJar()
            }
        }

        configureCommonAndroid(this)
    }
}