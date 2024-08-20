package ex.ex1

import typechecking.name

/**
 * @author Heshan Karunaratne
 */
interface Species {
    fun fun1() = "$name fun1"
    fun fun2()
}

class A : Species {
    override fun fun2() {
        println("$name fun2")
    }
}

open class B : Species {
    open fun fun0() = "fun0 A"
    override fun fun2() {
        println("$name fun2")
    }
}

// Not possible since A is not open
//class C : A() {}

class C : B() {
    override fun fun2() {
        println("$name Overrided fun2")
    }

    override fun fun0(): String {
       return "overidden"
    }
}

sealed class D : Species {
    fun fun3() {
        println("$name fun3")
    }
}

 abstract class E {
    abstract fun fun3()
    fun fun4() = "$name fun3"
}

class F : E() {
    override fun fun3() {
        println("$name fun3")
    }
}


