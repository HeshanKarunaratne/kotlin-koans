// NonNullAssertions/Task2.kt
package nonNullAssertionsExercise2

import atomictest.eq

fun List<Int>.headPlusTail(): Triple<Int?, Int?, Int?> {
    if (isEmpty()) return Triple(null, null, null)
    if (size == 1) return Triple(first(), null, first())
    return Triple(first(), last(), first() + last())
}

fun main() {
    val ints = mutableListOf<Int>()
    ints.headPlusTail() eq Triple(null, null, null)

    ints += 1
    ints.headPlusTail() eq Triple(1, null, 1)

    ints += 2
    ints.headPlusTail() eq Triple(1, 2, 3)
}