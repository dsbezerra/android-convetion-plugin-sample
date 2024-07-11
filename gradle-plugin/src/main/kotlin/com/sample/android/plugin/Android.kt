package com.sample.android.plugin

import PluginConstants.COMPOSE_BOM_VERSION
import PluginConstants.COMPOSE_COMPILER_VERSION
import PluginConstants.JAVA_VERSION
import PluginConstants.JVM_TARGET
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCommonAndroid(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = COMPOSE_COMPILER_VERSION
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = true

                proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
            }
        }

        dependencies {
            val bom = "androidx.compose:compose-bom:$COMPOSE_BOM_VERSION"
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("implementation", "androidx.compose.material3:material3")
            add("implementation", "androidx.compose.ui:ui-tooling-preview")
            add("debugImplementation", "androidx.compose.ui:ui-tooling")

            add("implementation", "androidx.activity:activity-compose:1.9.0")
        }

        compileOptions {
            sourceCompatibility = JAVA_VERSION
            targetCompatibility = JAVA_VERSION
        }

        kotlinOptions {
            jvmTarget = JVM_TARGET
        }

        testOptions {
            unitTests {
                isIncludeAndroidResources = true
                isReturnDefaultValues = true
            }
        }
    }
}

private fun CommonExtension<*, *, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}