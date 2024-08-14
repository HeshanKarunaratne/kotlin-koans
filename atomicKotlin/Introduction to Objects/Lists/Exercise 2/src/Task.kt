// Lists/Task2.kt
package listsExercise2

fun countOccurrences(list: IntList, number: Int): Int {
    var counter = 0
    for (item in list) {
        if (item == number) counter++
    }
    return counter
}

fun main() {
    val list = IntList(listOf(1, 2, 3, 2))
    println(countOccurrences(list, 2))  // 2
}