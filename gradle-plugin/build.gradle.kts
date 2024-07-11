@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
    `java-test-fixtures`
    alias(libs.plugins.pluginPublish)
}

group = "com.sample.android.plugin"
version = "1.0.0"

testing {
    suites {
        @Suppress("UnstableApiUsage")
        register("functionalTest", JvmTestSuite::class) {
            dependencies {
                useJUnitJupiter(libs.versions.junit.get())

                implementation(libs.truth)
                implementation(testFixtures(project(":")))
            }
        }
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.sample.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "com.sample.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
    }

    testSourceSets(sourceSets["testFixtures"], sourceSets["functionalTest"])
}

tasks.register("version") {
    doLast {
        println("###${version}###")
    }
}

dependencies {
    api(libs.android.gradlePlugin)
    api(libs.kotlin.gradlePlugin)

    testImplementation(gradleTestKit())
}
