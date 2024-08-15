// NullableTypes/Task2.kt
package nullableTypesExercise2

fun zilch(): String? = null
fun zilch2(): String? = zilch()

fun main() {
    val zilch: String? = zilch()
    val zilch2: String? = zilch2()
}