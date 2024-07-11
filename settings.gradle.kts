rootProject.name = "Android Convention Plugins Sample"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

includeBuild("gradle-plugin")

include(":examples:app")
include(":examples:lib")