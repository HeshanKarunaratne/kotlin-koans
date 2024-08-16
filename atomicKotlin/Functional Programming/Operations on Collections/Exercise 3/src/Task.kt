// OperationsOnCollections/Task3.kt
package operationsOnCollectionsExercise3
import atomictest.eq

fun sum(list: List<Int?>): Int =
    list.map { if (it == null) 0 else it }.sum()

fun main() {
  sum(listOf(1, 2, null)) eq 3
}