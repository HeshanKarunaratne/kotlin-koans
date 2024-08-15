// ExtensionProperties/Task2.kt
package extensionPropertiesExercise2

import atomictest.eq

val <T> List<T>.reversed: MutableList<T>
    get() {
        var list = mutableListOf<T>()
        for (i in lastIndex downTo 0) {
            list += get(i)
        }
        return list
    }

fun main() {

    val list = listOf(1, 2, 3)
    list.reversed eq listOf(3, 2, 1)


    val list2 = listOf("a", "c", "b")
    list2.reversed eq listOf("b", "c", "a")

}