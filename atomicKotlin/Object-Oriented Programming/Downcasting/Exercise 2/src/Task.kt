// DownCasting/DownCastEx2.kt
package downcastingExercise2
import downcasting.*
import atomictest.eq

val group: List<Creature> = listOf(
    Human(), Human(), Dog(), Alien(), Dog()
)

fun main() {
    group.filterIsInstance<Dog>()
        .map(Dog::bark) eq "[Yip!, Yip!]"
    group.filterIsInstance(Dog::class.java)
        .map(Dog::bark) eq "[Yip!, Yip!]"
}