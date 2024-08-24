// Interfaces/Task3.kt
package interfacesExercise3

import atomictest.eq
import operatoroverloading.invoke

interface Pet {
    val sound: String
}

class Dog() : Pet {
    override val sound: String
        get() = "Bark!"
}

class Cat : Pet {
    override val sound: String
        get() = "Meow!"
}

class Hamster : Pet {
    override val sound: String
        get() = "Squeak!"
}

fun main() {
    val list: List<Pet> = listOf(Dog(), Cat(), Hamster())
    list.map { it.sound } eq listOf("Bark!", "Meow!", "Squeak!")
}