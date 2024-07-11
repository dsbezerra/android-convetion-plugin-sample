import base.BaseFunctionalTest
import org.junit.jupiter.api.Test

internal class AndroidLibraryPluginFunctionalTest : BaseFunctionalTest() {

    @Test
    fun `should successfully register plugin`() {
        val script = """
            plugins {
                id("com.sample.android.application")
            }
        """

        testKit.givenBuildScript(script)
    }
}