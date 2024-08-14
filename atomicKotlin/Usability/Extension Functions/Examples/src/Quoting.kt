// ExtensionFunctions/Quoting.kt
package extensionfunctions
import atomictest.eq

fun String.singleQuote() = "'$this'"
fun String.doubleQuote() = "\"$this\""
fun String.twoDoubleQuotes() = "\"\"$this\"\""

fun main() {
  "Hi".singleQuote() eq "'Hi'"
  "Hi".doubleQuote() eq "\"Hi\""
  "Hi".twoDoubleQuotes() eq "\"\"Hi\"\""
  "Hi".singleQuote().singleQuote() eq "''Hi''"
}