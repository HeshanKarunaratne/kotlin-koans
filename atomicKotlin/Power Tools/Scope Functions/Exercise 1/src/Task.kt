// ScopeFunctions/Task1.kt
package scopeFunctionsExercise1
import atomictest.eq
import lateinitialization.y

data class NumPair(var x: Int, var y: Int) {
  fun add() = x + y
  fun subtract() = x - y
  fun multiply() = x * y
}

fun main() {
  val np1 = NumPair(10, 20)
  np1.apply {
    x += 5
    y += 6
  }
  np1 eq NumPair(15,26)

  val np2 = NumPair(30, 40)
  np2.also {
    it.x += 7
    it.y += 8
  }
  np2 eq NumPair(37,48)

  val result1 = np1.run { add() + subtract() + multiply() }
  result1 eq 420

  val result2 = np1.let { it.add() + it.subtract() + it.multiply() }
  result2 eq 420

  val result3 = with(np1) { add() + subtract() + multiply() }
  result3 eq 420
}
