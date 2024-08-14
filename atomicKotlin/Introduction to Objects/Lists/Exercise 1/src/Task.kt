// Lists/Task1.kt
package listsExercise1

import atomictest.eq

fun findMax(list: IntList): Int {
    var max = 0
    if (list.size() == 0) return max
    for (i in list) {
        if (i > max) max = i
    }
    return max
}

fun main() {
    val list = IntList(listOf(1, 2, 3, 2))
    findMax(list) eq 3
}