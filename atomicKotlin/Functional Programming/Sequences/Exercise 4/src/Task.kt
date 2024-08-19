// Sequences/Task4.kt
package sequencesExercise4

fun School.favoriteInstructor(student: Student): Instructor? {
  val filtered = lessons.filter { student in it.students }.toList()
  val grouped = filtered.groupBy { it.instructor }
  val maxElement = grouped.maxByOrNull { (_, lessons) -> lessons.size }
  return maxElement?.key
}