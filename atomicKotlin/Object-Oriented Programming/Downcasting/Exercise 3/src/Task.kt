// DownCasting/DownCastEx3.kt
package downcastingExercise3

import atomictest.eq
import atomictest.trace

interface Animal1

class Worm1 : Animal1 {
    fun wriggle() {
        trace("Wriggle")
    }
}

class Snail1 : Animal1 {
    fun slide() {
        trace("Slide")
    }
}

class Beetle1 : Animal1 {
    fun walk() {
        trace("Walk")
    }
}

fun move(a1: Animal1) {
    when (a1) {
        is Worm1 -> a1.wriggle()
        is Snail1 -> a1.slide()
        is Beetle1 -> a1.walk()
    }
}


interface Animal2 {
    fun move()
}

class Worm2 : Animal2 {
    override fun move() = trace("Wriggle")
}

class Snail2 : Animal2 {
    override fun move() = trace("Slide")
}

class Beetle2 : Animal2 {
    override fun move() = trace("Walk")
}


fun main() {
    val list = listOf(Worm1(), Snail1(), Beetle1())
    val list2 = listOf(Worm2(), Snail2(), Beetle2())
    list.forEach() { move(it) } eq trace(
        """
        Wriggle
        Slide
        Walk
    """.trimIndent()
    )

    list2.forEach() { it.move() } eq trace(
        """
        Wriggle
        Slide
        Walk
    """.trimIndent()
    )
}