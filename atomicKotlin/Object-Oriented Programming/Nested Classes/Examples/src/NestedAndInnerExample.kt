package nestedclasses

/**
 * @author Heshan Karunaratne
 */
class Outer {
    private val outerProperty: String = "Outer Property"

    // Regular Nested Class
    class Nested {
        fun nestedFunction() = "Hello from Nested Class"
    }
}

class Outer2 {
    private val outerProperty: String = "Outer Property"

    fun outerFun(): String {
        return "Outer2.outerFun"
    }

    // Inner Class
    inner class Inner {
        fun innerFunction() = "Accessing: $outerProperty"
        fun innerFun() = outerFun()
    }
}

fun main() {
    val nested = Outer.Nested()
    println(nested.nestedFunction())


    val inner = Outer2().Inner()
    println(inner.innerFunction())
    println(inner.innerFun())
}