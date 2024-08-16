// ImportanceOfLambdas/Task2.kt
package theImportanceOfLambdasExercise2
import atomictest.eq
import manipulatingListsExercise7.filter

fun filterNonBlank(strings: List<String>): List<String> =
  strings.filter { it.isNotBlank() }

fun main() {
  filterNonBlank(listOf("", "a", "  ")) eq listOf("a")
}