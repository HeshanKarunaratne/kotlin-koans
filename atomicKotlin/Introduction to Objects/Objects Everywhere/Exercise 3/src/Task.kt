// ObjectsEverywhere/Task3.kt
package objectsEverywhereExercise3

fun isPalindrome(s: String): Boolean = s.reversed() == s

fun isPalIgnoreCase(s: String): Boolean = isPalindrome(s.lowercase())

fun isPalIgnoreSpecial(s: String): Boolean {
    var result = ""
    for (ch in s) {
        if (isValidChar(ch)) result += ch
    }
    return isPalIgnoreCase(result)
}

fun isValidChar(ch: Char): Boolean {
    return ch in 'a'..'z' || ch in 'A'..'Z'
}

fun main() {
    println(isPalIgnoreSpecial("Was It A Rat I Saw? ..."))  // true
}