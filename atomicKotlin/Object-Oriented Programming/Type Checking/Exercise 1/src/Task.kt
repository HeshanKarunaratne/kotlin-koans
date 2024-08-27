// TypeChecking/TypeCheckingSoln1.kt
package typeCheckingExercise1
import atomictest.eq
import typechecking.name

interface Shape {
  fun draw() = "$name: Draw"
  fun rotate() = "$name: Rotate"
}

class Circle : Shape{
  override fun rotate() = ""
}

class Square : Shape

class Triangle : Shape

fun turn(s: Shape) = when(s) {
  is Square -> s.rotate()
  is Triangle -> s.rotate()
  else -> ""
}

fun main() {
  val shapes = listOf(Circle(), Square())
  shapes.map { it.draw() } eq
    "[Circle: Draw, Square: Draw]"
  shapes.map { turn(it) } eq
    "[, Square: Rotate]"
    shapes.map { it.rotate() } eq
    "[, Square: Rotate]"
}