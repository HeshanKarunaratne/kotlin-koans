// ExpressionsStatements/Task2.kt
package expressionsAndStatementsExercise2

fun f(i: Int, j: Int): Int = i + j

fun g(s: String, d: String): String = s + d

fun h() = println("h()")

fun main() {
    val a: Int = f(1, 2)
    val g: String = g("dfs", "dsfs")
    val h: Unit = h()
    println("Int")
    println("String")
    println("Unit")
}