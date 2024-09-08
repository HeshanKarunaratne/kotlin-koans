package scopefunctions

/**
 * @author Heshan Karunaratne
 */

fun letF() {
    val name: String? = null
    val result = name?.let {
        println("Name length: ${it.length}")
        it.length
    }
    println(result)
}

fun runF() {
    val name = "Kotlin"
    val result = name.run {
        println("Name: $this")
        length
    }
    println(result)
}

fun withF() {
    val name = "Kotlin"
    val result = with(name) {
        println("Name is $this")
        length
    }
    println(result)
}

fun applyF() {
    class User() {
        var name: String = ""
        var age: Int = 0
    }

    val user = User().apply {
        name = "Alice"
        age = 30
    }
    println(user)
}

fun alsoF() {
    val name = "Kotlin".also {
        println("Name length is: ${it.length}")
    }
    println(name)
}

fun main() {
    letF()
    runF()
    withF()
    applyF()
    alsoF()
}