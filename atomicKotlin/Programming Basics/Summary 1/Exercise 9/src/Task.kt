// Summary1/Task9.kt
package summaryIExercise9

fun printTriangle(n: Int) {
    val rows = n
    for (i in 1..rows) {
        for (x in 1..(rows - i)) print(" ")
        for (y in 1 until 2 * i) print("#")
        println()
    }
}

fun main() {
    printTriangle(4)
}/* Output:
   #
  ###
 #####
#######
*/