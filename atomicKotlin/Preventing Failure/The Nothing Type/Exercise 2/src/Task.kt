// NothingType/NothingTypeSoln2.kt
package theNothingTypeExercise2
import atomictest.*
import org.junit.internal.runners.statements.Fail

object Log {
  val messages:MutableList<String> = mutableListOf()
  fun add(msg: String) = messages.add(msg)
  fun report(): List<String> = messages.toList()
}

class Failure(msg: String) : Exception(msg)

fun fail(msg: String): Nothing {
  Log.add(msg)
  throw Failure(msg)
}

fun require(test: Boolean) {
  if (!test) fail("require failed")
}

fun check(test: Boolean) {
  if (!test) fail("check failed")
}

fun main() {
  require(true)
  check(true)
  capture {
    require(false)
  } eq "Failure: require failed"
  capture {
    check(false)
  } eq "Failure: check failed"
  Log.report() eq
    "[require failed, check failed]"
}