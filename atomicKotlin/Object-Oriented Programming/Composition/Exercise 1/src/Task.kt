// Composition/Task1.kt
package compositionExercise1

import atomictest.*

open class Shape(
    val name: String,
    open val color: String
) {
    open fun draw() = "drawing $color $name"
}

class Circle(
    val radius: Int,
    override val color: String
) : Shape("circle of radius", color) {
    override fun draw() = super.draw() + " $radius"
}

class Rectangle(
    val height: Int,
    val width: Int,
    override val color: String
) : Shape("rectangle of size", color) {
    override fun draw() = super.draw() + " ${height}x${width}"
}

fun main() {
    val circle = Circle(10, "red")
    val rectangle = Rectangle(3, 4, "blue")
    trace(circle.draw())
    trace(rectangle.draw())
    trace eq """
    drawing red circle of radius 10
    drawing blue rectangle of size 3x4
  """
}