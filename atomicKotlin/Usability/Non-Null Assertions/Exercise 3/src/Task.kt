// NonNullAssertions/Task3.kt
package nonNullAssertionsExercise3

import atomictest.eq

fun absMinIsMax(list: List<Int>): Boolean {
    if (list.isEmpty()) return false
    if (list.size == 1) return true

    list.sorted()
    val min = Math.abs(list.first())
    val max = Math.abs(list.last())
    return min == max
}

fun main() {
    absMinIsMax(listOf(-10, 1, 10)) eq true
    absMinIsMax(listOf(10, 10)) eq true
    absMinIsMax(listOf(-10, 1)) eq false
}