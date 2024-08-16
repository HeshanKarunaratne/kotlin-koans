// Lambdas/Underscore.kt
import atomictest.eq

fun main() {
  val list = listOf('a', 'b', 'c')
  list.mapIndexed { index, el ->
    "[$index]:[$el]"
  } eq listOf("[0]:[a]", "[1]:[b]", "[2]:[c]")
}