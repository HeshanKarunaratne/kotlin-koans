// Sequences/DefineTakeIf.kt
package sequences
import atomictest.eq

fun <T> T.takeIf(predicate: (T) -> Boolean): String {
  return if (predicate(this)) "true" else "wrong"
}

fun main() {
  "abc".takeIf { it != "XXX" } eq "true"
  "XXX".takeIf { it != "XXX" } eq "wrong"
}