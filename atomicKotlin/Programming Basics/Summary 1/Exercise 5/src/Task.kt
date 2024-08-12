// Summary1/Task5.kt
package summaryIExercise5

fun everyFifth(start: Int, end: Int) {
    var count = 0
    for (i in start..end) {
        count++
        if (count == 5) {
            println(i)
            count = 0
        }
    }
}

fun main() {
    everyFifth(11, 30)
}/* Output:
15
20
25
30
*/