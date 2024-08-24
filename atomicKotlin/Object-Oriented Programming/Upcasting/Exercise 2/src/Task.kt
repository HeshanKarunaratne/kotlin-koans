// Upcasting/Task2.kt
package upcastingExercise2

import atomictest.eq

interface Apple {
    fun consume(): String
}

class GrannySmith : Apple {
    override fun consume(): String {
        return "chomp GrannySmith"
    }
}

class Gala : Apple {
    override fun consume(): String {
        return "bite Gala"
    }
}

class Fuji : Apple {
    override fun consume(): String {
        return "press Fuji"
    }
}

class Braeburn : Apple {
    override fun consume(): String {
        return "peel Braeburn"
    }
}

fun main() {
    val apples = listOf(
        GrannySmith(),
        Gala(),
        Fuji(),
        Braeburn()
    )
    apples.map { it.consume() } eq
            "[chomp GrannySmith, " +
            "bite Gala, press Fuji, peel Braeburn]"
}