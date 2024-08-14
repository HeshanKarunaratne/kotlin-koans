// Varargs/Task2.kt
package variableArgumentListsExercise2

fun printArgs(a: String, vararg b: Int) {
    println(a + b.toList())
}

fun main() {
    printArgs("Numbers: ", 1, 2, 3)
}
/* Expected output:
Numbers: [1, 2, 3]
 */