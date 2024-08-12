// RepetitionWithWhile/Task2.kt
package repetitionWithWhileExercise2

fun sum(number: Int): Int {
    var i = 0
    var sum = 0

    while (i <= number) {
        sum += i
        i++
    }
    return sum
}

fun main() {
    println(sum(10))  // 55
}