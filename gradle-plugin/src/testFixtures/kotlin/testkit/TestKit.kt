package testkit

import org.gradle.internal.impldep.org.junit.Rule
import org.gradle.internal.impldep.org.junit.rules.TemporaryFolder
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import java.io.File

internal const val BUILD_SCRIPT_FILE = "build.gradle.kts"
internal const val SETTINGS_FILE = "settings.gradle.kts"

class TestKit {

    @Rule
    @JvmField
    val temporaryFolder = TemporaryFolder().apply { create() }

    init {
        setupTestProject()
    }

    fun givenBuildScript(script: String): File =
        newFile(BUILD_SCRIPT_FILE).apply { writeText(script) }

    private fun newFile(name: String): File = temporaryFolder.newFile(name)

    private fun setupTestProject() {
        newFile(SETTINGS_FILE).writeText(getSettingsContent())
    }

    fun build(vararg arguments: String): BuildResult {
        return GradleRunner
            .create()
            .forwardOutput()
            .withProjectDir(temporaryFolder.root)
            .withPluginClasspath()
            .withArguments(*arguments)
            .build()
    }

    fun isBuildSuccessful(buildResult: BuildResult) =
        buildResult.output.contains("BUILD SUCCESSFUL")

    fun checkTaskNotFound(taskName: String, output: String?): Boolean {
        return output?.contains("Task '$taskName' not found") == true
    }

    fun checkTaskExists(taskName: String): Boolean {
        return build("tasks").output.contains(taskName)
    }

    fun reset() {
        temporaryFolder.delete()
        temporaryFolder.create()
    }

    private fun getSettingsContent(): String {
        return """
            rootProject.name = "Testing Project"
            
            dependencyResolutionManagement {
                repositories {
                    mavenLocal()
                    mavenCentral()
                }
            }
        """
    }
}