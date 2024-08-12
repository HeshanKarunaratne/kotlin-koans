// RepetitionWithWhile/Task1.kt
package repetitionWithWhileExercise1

fun displayContent(content: String) {
    val toCharArray = content.toCharArray()
    var i = 0
    while (i < toCharArray.size) {
        println(toCharArray[i])
        i++
    }
}

fun main() {
    displayContent("abc")
}/* Expected output:
a
b
c
*/