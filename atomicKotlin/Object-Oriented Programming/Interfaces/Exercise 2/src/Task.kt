// Interfaces/Task2.kt
package interfacesExercise2

import atomictest.eq

fun interface Pet {
    fun speak(): String
}

class Dog : Pet {
    override fun speak(): String {
        return "Bark!"
    }

}

class Cat : Pet {
    override fun speak(): String {
        return "Meow!"
    }
}

class Hamster : Pet {
    override fun speak(): String {
        return "Squeak!"
    }
}

fun main() {
    val list: List<Pet> = listOf(Dog(), Cat(), Hamster())
    list.map { it.speak() } eq listOf("Bark!", "Meow!", "Squeak!")
}