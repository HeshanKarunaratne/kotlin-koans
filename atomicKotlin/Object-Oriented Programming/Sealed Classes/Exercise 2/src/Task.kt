// SealedClasses/SealedEx2.kt
package sealedClassesExercise2

import atomictest.trace
import sealedClassesExercise1.Transport

fun main() {
    Transport::class.sealedSubclasses.map { it.simpleName }.forEach { trace(it) }
    trace eq """
Bus
Plane
Train
Tram
  """
}