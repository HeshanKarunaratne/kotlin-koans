// IntroGenerics/Task3.kt
package introductionToGenericsExercise3

import atomictest.eq

class CountingSet<E> {
    private var mutableMap = mutableMapOf<E, Int>()

    fun add(element: E) {
        val count = mutableMap[element]
        if (count == null) mutableMap[element] = 1
        else mutableMap[element] = count + 1
    }

    fun count(element: E): Int = mutableMap[element] ?: 0

    fun toSet(): Set<E> = mutableMap.keys

}

fun main() {

    val cs = CountingSet<String>()
    cs.add("abc")
    cs.add("abc")
    cs.add("def")
    cs.count("abc") eq 2
    cs.count("def") eq 1
    cs.count("xyz") eq 0

    println(cs.toSet())
}