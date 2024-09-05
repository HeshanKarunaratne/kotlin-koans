// Tests/unittesting/UnitTestingSoln1.kt
package unitTestingExercise1
import sealedclasses.Bus
import sealedclasses.Train
import sealedclasses.travel

import kotlin.test.*

class Tast1Test {
    @Test
    fun `train travel`() {
        val train = Train("S1")
        val result = travel(train)
        assertEquals("Train S1", result)
    }

    @Test
    fun `bus travel`() {
        val bus = Bus("11", 90)
        val result = travel(bus)
        assertEquals("Bus 11: size 90", result)
    }

}