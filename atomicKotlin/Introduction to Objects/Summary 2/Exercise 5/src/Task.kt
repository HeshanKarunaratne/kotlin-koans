// Summary2/Task5.kt
package summaryIIExercise5

fun va1(vararg i1: Int) {
    println("va1:")
    for (item1 in i1) {
        println(item1)
    }
}

fun va2(vararg i2: Int) {
    println("va2:")
    va1(*i2)
}

fun main() {
    va1(1, 2, 3)
    va2(4, 5, 6)
}/* Expected output:
va1:
1
2
3
va2:
va1:
4
5
6
 */