// BreakAndContinue/Task1.kt
package breakAndContinueExercise1

import atomictest.trace

fun readNumbers(vararg n: String) {
    var sum = 0
    for (i in n) {
        if (i == "0") {
            trace("Sum: $sum")
            break
        }
        val intValue = i.toIntOrNull()
        if (intValue == null) {
            trace("Not a number: $i")
            continue
        }
        sum += intValue
    }

}

fun main() {
    readNumbers("1", "a", "3", "10", "0", "19")
    trace eq """
    Not a number: a
    Sum: 14
  """
}