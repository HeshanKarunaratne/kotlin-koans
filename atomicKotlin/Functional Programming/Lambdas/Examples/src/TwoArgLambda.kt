// Lambdas/TwoArgLambda.kt
import atomictest.eq

fun main() {
  val list = listOf('a', 'b', 'c')
  list.mapIndexed { i, el ->
    "[$i: $el]"
  } eq listOf("[0: a]", "[1: b]", "[2: c]")
}