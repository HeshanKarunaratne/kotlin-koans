// Enumerations/Task3.kt
package enumerationsExercise3

import atomictest.eq
import enumerationsExercise3.Result.*
import enumerationsExercise3.Rochambeau.*

enum class Rochambeau {
    ROCK, PAPER, SCISSORS
}

enum class Result {
    DRAW, FIRST_WINS, SECOND_WINS
}

fun winner(first: Rochambeau, second: Rochambeau): Result {
    return when {
        first == second -> DRAW
        first == ROCK && second == PAPER -> SECOND_WINS
        first == ROCK && second == SCISSORS -> FIRST_WINS
        first == PAPER && second == ROCK -> FIRST_WINS
        first == PAPER && second == SCISSORS -> SECOND_WINS
        first == SCISSORS && second == ROCK -> SECOND_WINS
        first == SCISSORS && second == PAPER -> FIRST_WINS
        else -> DRAW
    }
}

fun main() {
    winner(ROCK, SCISSORS) eq FIRST_WINS
    winner(SCISSORS, ROCK) eq SECOND_WINS
    winner(PAPER, PAPER) eq DRAW
}