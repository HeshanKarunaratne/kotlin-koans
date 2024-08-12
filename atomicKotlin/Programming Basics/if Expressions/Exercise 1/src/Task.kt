// IfExpressions/Task1.kt
package ifExpressionsExercise1

fun checkSign(number: Int): String {
  if (number == 0) return "zero"
  return if (number > 0) "positive"
  else "negative"
}


fun main() {
  println(checkSign(-19))  // negative
}