// Sequences/Task2.kt
package sequencesExercise2

fun School.studentInstructors(student: Student): Set<Instructor> {
    return lessons.filter { student in it.students }.map { it.instructor }.toSet()
}

fun School.studentsOf(instructor: Instructor): Set<Student> {
    return lessons.filter { instructor == it.instructor }.flatMap { it.students }.toSet()
}