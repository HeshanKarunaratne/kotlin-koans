// LoopingAndRanges/Task1.kt
package loopingAndRangesExercise1

fun factorial(n: Int): Long {
    var output: Long = 1
    for (i in 1..n) {
        output *= i
    }
    return output
}

fun main() {
    println(factorial(10))  // 3628800
}