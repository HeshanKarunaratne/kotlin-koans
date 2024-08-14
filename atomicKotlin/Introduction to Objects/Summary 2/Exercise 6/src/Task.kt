// Summary2/Task6.kt
package summaryIIExercise6

import atomictest.eq

class Temperature {

    private var scale = "f"
    var celsius = 0.0
        get() {
            return if (scale == "c") field
            else (fahrenheit - 32.0) * 5.0 / 9.0
        }
        set(value) {
            field = value
            scale = "c"
        }

    var fahrenheit = 0.0
        get() {
            return if (scale == "f") field
            else celsius * 9.0 / 5.0 + 32.0
        }
        set(value) {
            field = value
            scale = "f"
        }

}

fun main() {
    val temp = Temperature()

    temp.fahrenheit = 98.6
    temp.fahrenheit eq 98.6
    temp.celsius eq 37.0
    temp.celsius = 100.0
    temp.fahrenheit eq 212.0
}