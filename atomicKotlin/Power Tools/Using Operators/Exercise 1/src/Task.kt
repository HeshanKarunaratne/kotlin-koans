// UsingOperators/UsingOperatorsSoln1.kt
package usingOperatorsExercise1

import atomictest.trace


data class DataMany(
    val a: Int = 1,
    val b: Int = 2,
    val c: Int = 3,
    val d: Int = 4,
    val e: Int = 5,
    val f: Int = 6,
    val g: Int = 7,
    val h: Int = 8,
    val i: Int = 9,
    val j: Int = 10,
)

fun all() {
    val (a, b, c, d, e, f, g, h, i, j) = DataMany()
    val data = DataMany()
    trace("$a $b $c $d $e $f $g $h $i $j")
    trace(data.component1())
    trace(data.component10())
}

fun firstHalf() {
    val (a, b, c, d, e, _) = DataMany()
    trace("$a $b $c $d $e")
}

fun secondHalf() {
    val (_, _, _, _, _, f, g, h, i, j) = DataMany()
    trace("$f $g $h $i $j")

}

fun interspersed() {
    val (a, _, c, _, e, _, g, _, i, _) = DataMany()
    trace("$a $c $e $g $i")
}

fun main() {
    all()
    firstHalf()
    secondHalf()
    interspersed()
    trace eq """
    1 2 3 4 5 6 7 8 9 10
    1
    10
    1 2 3 4 5
    6 7 8 9 10
    1 3 5 7 9
  """
}