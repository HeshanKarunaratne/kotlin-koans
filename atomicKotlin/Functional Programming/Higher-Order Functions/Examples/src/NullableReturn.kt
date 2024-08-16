// HigherOrderFunctions/NullableReturn.kt
import atomictest.eq

val transform: (String) -> Int? =
    { s: String -> s.toIntOrNull() }

fun main() {
    transform("112") eq 112
    transform("abc") eq null
    val x = listOf("112", "abc")
    x.mapNotNull(transform) eq "[112]"
    x.mapNotNull { it.toIntOrNull() } eq "[112]"
}