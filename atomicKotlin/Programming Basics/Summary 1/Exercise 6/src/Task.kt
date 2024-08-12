// Summary1/Task6.kt
package summaryIExercise6

fun everyFifthNonSpace(s: String) {
    var index = 0
    for (c in s) {
        if (c == ' ') continue
        index++
        if (index == 5) {
            println(c)
            index = 0
        }
    }
}

fun main() {
    everyFifthNonSpace("abc d e fgh ik")
}
/* Output:
e
k
*/