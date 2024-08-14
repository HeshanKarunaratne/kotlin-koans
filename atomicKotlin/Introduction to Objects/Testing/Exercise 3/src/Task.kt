// Testing/Task3.kt
package testingExercise3
import atomictest.eq
import atomictest.neq

fun squareArea(x: Int) = x * x

fun rectangleArea(x: Int, y: Int) = x * y

fun trapezoidArea(x: Int, y: Int, h: Int) = h / 2.0 * (x + y)

fun main() {
  squareArea(1) eq 1
  squareArea(2) eq 4
  squareArea(5) eq 25
  rectangleArea(2,3) eq 6
  rectangleArea(2,3) neq 5
  rectangleArea(1,2) eq 2
  trapezoidArea(1,2,2) eq 3.0
  trapezoidArea(1,2,2) neq 4.0
  trapezoidArea(2,4,4) eq 12.0
  trapezoidArea(2,4,4) neq 10.0
}