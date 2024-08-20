// DownCasting/IsKeyword.kt
import downcasting.*

fun main() {
  val b1: Base = Derived1() // Upcast
  if(b1 is Derived1)
    b1.g() // Within scope of "is" check
  val b2: Base = Derived2() // Upcast
  if(b2 is Derived1)
    b2.g() // Within scope of "is" check
}