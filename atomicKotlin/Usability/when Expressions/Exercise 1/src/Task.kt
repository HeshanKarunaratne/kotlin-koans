// WhenExpressions/Task1.kt
package whenExpressionsExercise1

import atomictest.capture
import atomictest.eq

fun cloudinessV1(cloudPercent: Int): String {
    return if (cloudPercent in 81..100) "Cloudy"
    else if (cloudPercent in 61..80) "Mostly Cloudy"
    else if (cloudPercent in 41..60) "Partly Sunny"
    else if (cloudPercent in 21..40) "Mostly Sunny"
    else if (cloudPercent in 0..20) "Sunny"
    else throw IllegalArgumentException("Cloudiness value should be between 0 and 100")
}

fun cloudinessV2(cloudPercent: Int): String {
    return when (cloudPercent) {
        in 81..100 -> "Cloudy"
        in 61..80 -> "Mostly Cloudy"
        in 41..60 -> "Partly Sunny"
        in 21..40 -> "Mostly Sunny"
        in 0..20 -> "Sunny"
        else -> throw IllegalArgumentException(
            "Cloudiness value should be between 0 and 100"
        )
    }

    fun main() {
        cloudinessV1(100) eq "Cloudy"
        cloudinessV1(70) eq "Mostly Cloudy"
        cloudinessV1(50) eq "Partly Sunny"
        cloudinessV1(30) eq "Mostly Sunny"
        cloudinessV1(0) eq "Sunny"
        capture {
            cloudinessV1(1000)
        } eq "IllegalArgumentException: Cloudiness value should be between 0 and 100"
    }
}