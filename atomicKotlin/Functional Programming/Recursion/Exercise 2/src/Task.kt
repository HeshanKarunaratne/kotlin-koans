// Recursion/Task2.kt
package recursionExercise2

import atomictest.eq

fun factorial(n: Long): Long {
    tailrec fun factorial(n: Long, x: Long): Long {
        if (n == 0L) return x
        return factorial(n - 1, n * x)
    }
    return factorial(n, 1L)
}

fun main() {
    factorial(3) eq 6
    factorial(4) eq 24
    factorial(11) eq 39916800
}