// MemberReferences/MemberReferencesEx1.kt
package memberReferencesExercise1
import atomictest.eq
import memberReferencesExercise1.Habitat.*

data class Pet(
    var name: String,
    val habitat: Habitat
) {
    override fun toString() = name
}

enum class Habitat {
    LAND, WATER, AMPHIBIOUS;

    fun livesIn(pet: Pet) = pet.habitat == this
}

fun List<Pet>.liveOnLand(): List<Pet> =
    filter { pet -> pet.habitat == LAND }

fun List<Pet>.liveInWater(): List<Pet> =
    filter { pet -> pet.habitat == WATER }

fun List<Pet>.areAmphibious(): List<Pet> =
    filter { pet -> pet.habitat == AMPHIBIOUS }

fun List<Pet>.partitionAmphibious(): Pair<List<Pet>, List<Pet>> = partition { pet -> pet.habitat == AMPHIBIOUS }

fun main() {
    val pets = listOf(
        Pet("Dog", LAND),
        Pet("Cat", LAND),
        Pet("Goldfish", WATER),
        Pet("Turtle", AMPHIBIOUS),
        Pet("Frog", AMPHIBIOUS)
    )
    pets.liveOnLand() eq "[Dog, Cat]"
    pets.liveInWater() eq "[Goldfish]"
    pets.areAmphibious() eq "[Turtle, Frog]"
    pets.partitionAmphibious() eq
            "([Turtle, Frog], [Dog, Cat, Goldfish])"
}