// SecondaryConstructors/WithSecondary.kt
package secondaryconstructors
import atomictest.*

class WithSecondary(i: Int) {
  init {
    trace("Primary: $i")
  }
  constructor(c: Char) : this(c - 'A') {
    trace("Secondary: '$c'")
  }
  constructor(s: String) :
    this(s.first()) {             // [1]
    trace("Secondary: \"$s\"")
  }

  constructor(f: Float) : this(26) {
    trace("Secondary float: $f")
  }

}

fun main() {
  fun sep() = trace("-".repeat(10))
  WithSecondary(1)
  sep()
  WithSecondary('D')
  sep()
  WithSecondary("Last Constructor")
  sep()
  WithSecondary(26.0F)
  trace eq """
    Primary: 1
    ----------
    Primary: 3
    Secondary: 'D'
    ----------
    Primary: 11
    Secondary: 'L'
    Secondary: "Last Constructor"
    ----------
    Primary: 26
    Secondary float: 26.0
  """
}