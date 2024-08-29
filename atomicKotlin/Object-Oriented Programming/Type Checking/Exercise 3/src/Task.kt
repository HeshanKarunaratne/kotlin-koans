// TypeChecking/TypeCheckingSoln3.kt
package typeCheckingExercise3

import atomictest.eq
import typechecking.name

sealed class Insect {
    fun walk() = "$name: walk"
    open fun fly() = "$name: fly"
}

class HouseFly : Insect()

class Flea : Insect() {
    override fun fly() = throw Exception("Flea cannot fly")

    fun crawl() = "Flea: crawl"
}

fun Insect.basic() = when (this) {
    is Flea -> walk() + " " + crawl()
    else -> walk() + " " + fly()
}


interface SwimmingInsect {
    fun swim() = "$name: swim"
}

interface WaterWalker {
    fun walkWater() = "$name: walk on water"
}

class WaterBeetle : SwimmingInsect, Insect()
class WaterStrider : WaterWalker, Insect()
class WhirligigBeetle : SwimmingInsect, WaterWalker, Insect()

fun Insect.water() = when (this) {
    is SwimmingInsect -> swim()
    is WaterWalker -> walkWater()
    else -> "$name: drown"
}

fun main() {
    val insects = listOf(
        HouseFly(), Flea(), WaterStrider(), WaterBeetle(), WhirligigBeetle()
    )
    insects.map { it.basic() } eq "[HouseFly: walk HouseFly: fly, " + "Flea: walk Flea: crawl, " + "WaterStrider: walk WaterStrider: fly, " + "WaterBeetle: walk WaterBeetle: fly, " + "WhirligigBeetle: walk " + "WhirligigBeetle: fly]"
    insects.map { it.water() } eq "[HouseFly: drown, Flea: drown, " + "WaterStrider: walk on water, " + "WaterBeetle: swim, " + "WhirligigBeetle: swim]"
}