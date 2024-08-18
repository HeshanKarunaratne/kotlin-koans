// Sequences/Task1.kt
package sequencesExercise1

fun School.commonLessons(instructor: Instructor, student: Student): Sequence<Lesson> {
    return lessons.filter { lesson -> lesson.instructor == instructor && student in lesson.students }
}
