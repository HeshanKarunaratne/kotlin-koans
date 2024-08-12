// NumberTypes/Task4.kt
package numberTypesExercise4

//1s -> 1000
//1m -> 1*60*1000
//1h -> 60*60*1000

fun convertToMilliseconds(hours: Long, minutes: Long, seconds: Long): Long =
    (hours * 60 * 60 * 1000) + (minutes * 60 * 1000) + (seconds * 1000)


fun main() {
    println(convertToMilliseconds(1, 30, 0))
}