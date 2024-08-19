// Interfaces/SAMImplementation.kt
package interfaces

import atomictest.eq

class VerboseZero : ZeroArg {
    override fun f() = 11
}

val verboseZero = VerboseZero()

val samZero = ZeroArg { 11 }

class VerboseOne : OneArg {
    override fun g(n: Int) = n + 47
}

val verboseOne = VerboseOne()

val samOne = OneArg { it + 47 }

class VerboseTwo : TwoArg {
    override fun h(i: Int, j: Int) = i + j
}

val verboseTwo = VerboseTwo()

val samTwo = TwoArg { i, j -> i + j }

class VerboseThree : ThreeArg {
    override fun i(i: Int, j: Int, k: Int) = i + j - k
}

val verboseThree = VerboseThree()

val samThree = ThreeArg { i, j, k -> i + j - k }

fun main() {
    verboseZero.f() eq 11
    samZero.f() eq 11
    verboseOne.g(92) eq 139
    samOne.g(92) eq 139
    verboseTwo.h(11, 47) eq 58
    samTwo.h(11, 47) eq 58
    verboseThree.i(10, 30, 20) eq 20
    samThree.i(10, 30, 20) eq 20
}