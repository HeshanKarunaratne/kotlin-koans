// WhenExpressions/Task3.kt
package whenExpressionsExercise3

import atomictest.eq

fun balanced(input: String): Boolean {
    var count = 0
    for (char in input) {
        if (count < 0) return false
        when {
            char == '(' -> count++
            char == ')' -> count--
            char == ' ' -> continue
            else -> throw IllegalArgumentException()
        }
    }
    return count == 0
}

fun main() {
    balanced("(()) ()") eq true
    balanced(")(") eq false
}