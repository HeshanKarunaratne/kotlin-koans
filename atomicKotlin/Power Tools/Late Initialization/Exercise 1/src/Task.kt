// LateInitialization/LateInitSoln1.kt
package lateInitializationExercise1

interface PowerPlant

lateinit var car: Vehicle

class ElectricMotor : PowerPlant
class CombustionEngine : PowerPlant
class Vehicle() {
    lateinit var powerPlant: PowerPlant
}

fun main() {
    lateinit var truck: Vehicle
    car = Vehicle()
    car.powerPlant = ElectricMotor()
    truck = Vehicle()
    truck.powerPlant = CombustionEngine()
}