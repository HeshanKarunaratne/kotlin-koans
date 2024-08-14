// Summary2/Task8.kt
package summaryIIExercise8

import atomictest.eq

val romanNumeralToIntMap: Map<Char, Int> = mapOf(
    'M' to 1000, 'D' to 500, 'C' to 100, 'L' to 50, 'X' to 10, 'V' to 5, 'I' to 1
)

fun convertFromRoman(roman: String): Int {
    var result = 0
    result = romanNumeralToIntMap[roman[roman.length - 1]]!!

    for (i in roman.length - 2 downTo 0) {
        val currentValue = romanNumeralToIntMap[roman[i]]!!
        val nextValue = romanNumeralToIntMap[roman[i+1]]!!

        if (currentValue >= nextValue) {
            result += currentValue
        } else {
            result -=  currentValue
        }
    }
    return result
}

fun main() {
    convertFromRoman("XXIII") eq 23
    convertFromRoman("XLIV") eq 44
    convertFromRoman("C") eq 100
    convertFromRoman("MMXVIII") eq 2018
}