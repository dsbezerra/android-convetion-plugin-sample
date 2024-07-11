import org.gradle.api.JavaVersion

object PluginConstants {
    const val ANDROID_APPLICATION_PLUGIN_ID = "com.android.application"
    const val ANDROID_LIBRARY_PLUGIN_ID = "com.android.library"
    const val MAVEN_PUBLISH_PLUGIN_ID = "maven-publish"

    const val KOTLIN_ANDROID_PLUGIN_ID = "org.jetbrains.kotlin.android"
    const val KAPT_PLUGIN_ID = "org.jetbrains.kotlin.kapt"
    const val KOTLIN_PARCELIZE_PLUGIN_ID = "kotlin-parcelize"

    const val APPLICATION_COMPONENT_NAME = "debug"
    const val LIBRARY_COMPONENT_NAME = "release"

    const val MIN_SDK = 21
    const val COMPILE_SDK = 34
    const val TARGET_SDK = 34

    const val COMPOSE_BOM_VERSION = "2024.06.00"
    const val COMPOSE_COMPILER_VERSION = "1.5.14"

    val JAVA_VERSION = JavaVersion.VERSION_1_8
    val JVM_TARGET = JAVA_VERSION.toString()
}