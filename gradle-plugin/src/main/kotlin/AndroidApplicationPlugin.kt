import PluginConstants.ANDROID_APPLICATION_PLUGIN_ID
import PluginConstants.KAPT_PLUGIN_ID
import PluginConstants.KOTLIN_ANDROID_PLUGIN_ID
import PluginConstants.KOTLIN_PARCELIZE_PLUGIN_ID
import PluginConstants.MAVEN_PUBLISH_PLUGIN_ID
import com.sample.android.plugin.configureApplication
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(ANDROID_APPLICATION_PLUGIN_ID)
                apply(KOTLIN_ANDROID_PLUGIN_ID)
                apply(KOTLIN_PARCELIZE_PLUGIN_ID)
                apply(KAPT_PLUGIN_ID)
                apply(MAVEN_PUBLISH_PLUGIN_ID)
            }
            configureApplication()
        }
    }
}