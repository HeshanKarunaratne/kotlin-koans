// Summary1/Task10.kt
package summaryIExercise10

fun showSnake(rows: Int, columns: Int) {
    val width = (rows * columns).toString().length + 1
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            if (i % 2 == 0) {
                //even
                printNum(width, (columns * i) + j)
            } else {
                //odd
                printNum(width, (columns * i) + (columns - j - 1))
            }
        }
        println()
    }
}

fun printNum(width: Int, num: Int) {
    print("%${width}d".format(num))
}

fun main() {
    showSnake(2, 3)
    println()
    showSnake(4, 5)
}/* Output:
 0 1 2
 5 4 3

  0  1  2  3  4
  9  8  7  6  5
 10 11 12 13 14
 19 18 17 16 15
*/