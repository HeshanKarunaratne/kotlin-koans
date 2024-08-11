// DataTypes/Task2.kt
package dataTypesExercise2

fun main() {
  val int: Int = 10
  val double: Double = 1.1
  val boolean: Boolean = false
  val string: String = "abc"
  val character: Char = 'a'

  // Can be combined:
  var x1 = string + double
  var x2 = string + boolean
  var x3 = string + int
  var x4 = string + character


  println("The type that can be combined " +
    "with every other type using '+':")
  println("String")

  // Can't be combined:

}