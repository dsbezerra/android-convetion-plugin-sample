package base

import org.junit.jupiter.api.AfterEach
import testkit.TestKit

internal abstract class BaseFunctionalTest {

    protected val testKit: TestKit = TestKit()

    @AfterEach
    fun tearDown() {
        testKit.reset()
    }
}