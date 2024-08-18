// MemberReferences/ExtensionReference.kt
package memberreferences

import atomictest.eq

class Frog

fun goInt(n: Int, g: (Int) -> Int): Int = g(n) // Extension Reference
fun goFrog(frog: Frog, g: (Frog) -> String) = g(frog) // Extension Reference

fun Frog.speak() = "Ribbit!"  //Extension function
fun Int.times47() = times(47) //Extension function

fun main() {
    goInt(12, Int::times47) eq 564  // Function
                 // Member Reference
    goFrog(Frog(), Frog::speak) eq "Ribbit!" // Functions
}