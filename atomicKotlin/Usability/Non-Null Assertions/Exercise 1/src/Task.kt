// NonNullAssertions/Task1.kt
package nonNullAssertionsExercise1

import atomictest.capture
import atomictest.eq

class Rocket() {
    fun ignition() = "Liftoff!"
}

fun launch(rocket: Rocket?) = rocket!!.ignition()

fun main() {

    val rocket = Rocket()
    launch(rocket) eq "Liftoff!"
    capture {
        launch(null)
    } eq "NullPointerException"

}