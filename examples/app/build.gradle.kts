plugins {
    id("com.sample.android.application")
}

android {
    namespace = "com.sample.android.app"
}

dependencies {
    implementation(project(":examples:lib"))
}