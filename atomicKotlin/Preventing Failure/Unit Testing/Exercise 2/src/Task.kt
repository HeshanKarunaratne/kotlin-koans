// Tests/unittesting/UnitTestingSoln2.kt
package unitTestingExercise2
import interfaces.Desktop
import interfaces.DeepThought
import interfaces.Quantum

import kotlin.test.*

class Test2Test{
    @Test
    fun `desktop computer`() {
        val desktop = Desktop()
        assertEquals("Hello!", desktop.prompt())
        assertEquals(11, desktop.calculateAnswer())
    }

    @Test
    fun `deepThought computer`() {
        val deepThought = DeepThought()
        assertEquals("Thinking...", deepThought.prompt())
        assertEquals(42, deepThought.calculateAnswer())
    }

    @Test
    fun `quantum computer`() {
        val quantum = Quantum()
        assertEquals("Probably...", quantum.prompt())
        assertEquals(-1, quantum.calculateAnswer())
    }

}