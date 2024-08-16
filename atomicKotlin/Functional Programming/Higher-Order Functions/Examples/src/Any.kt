// HigherOrderFunctions/Any.kt
package higherorderfunctions

import atomictest.eq

fun <T> List<T>.any(predicate: (T) -> Boolean): Boolean {
    for (element in this) {
        if (predicate(element))             // [3]
            return true
    }
    return false
}

fun main() {
    val ints = listOf(1, 2, -3)
    ints.any { it > 0 } eq true           // [4]

    val strings = listOf("abc", " ")
    strings.any { it.isBlank() } eq true  // [5]
    strings.any(String::isNotBlank) eq    // [6]
            true
}