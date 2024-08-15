// WhenExpressions/Task2.kt
package whenExpressionsExercise2

import atomictest.eq

fun temperature(temperature: Int): String =
    when (temperature) {
        in 25..Int.MAX_VALUE -> "Hot"
        in 15..24 -> "Warm"
        in 5..14 -> "Cool"
        in -5..4 -> "Cold"
        else -> "Freezing"
    }

fun main() {
    temperature(30) eq "Hot"
    temperature(10) eq "Cool"
    temperature(-30) eq "Freezing"
}