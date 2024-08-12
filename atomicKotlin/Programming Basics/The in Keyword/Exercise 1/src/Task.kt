// InKeyword/Task1.kt
package theInKeywordExercise1

fun getAlphabet(): String {
    var output = ""
    for (i in 'a'..'z') {
        output += i
    }
    return output
}

fun main() {
    println(getAlphabet())  // abcdefghijklmnopqrstuvwxyz
}