import base.BaseFunctionalTest
import org.junit.jupiter.api.Test

internal class AndroidApplicationPluginFunctionalTest : BaseFunctionalTest() {

    @Test
    fun `should successfully register plugin`() {
        val script = """
            plugins {
                id("com.sample.android.library")
            }
        """
        testKit.givenBuildScript(script)
    }
}