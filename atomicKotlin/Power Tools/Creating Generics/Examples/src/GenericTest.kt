/**
 * @author Heshan Karunaratne
 */
class GenericTest<T> {
    private val list = mutableListOf<T>()
    fun add(t: T) = list.add(t)
    fun print() {
        for (item in list) println(item)
    }
}

fun main() {
    val g1 = GenericTest<String>()
    g1.add("g11")
    g1.add("g12")
    g1.print()

    println()
    val g2 = GenericTest<Int>()
    g2.add(1)
    g2.add(2)
    g2.print()
}