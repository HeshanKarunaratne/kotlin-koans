/**
 * @author Heshan Karunaratne
 */
data class Instructor(val name: String)

data class Student(val name: String)

data class Lesson(
    val instructor: Instructor, val students: Set<Student>, val rating: Map<Student, Int>
)

data class School(
    val instructors: Set<Instructor>, val students: Set<Student>, val lessons: Sequence<Lesson>
)

// Instructors
val instructorJohn = Instructor("John Smith")
val instructorEmily = Instructor("Emily Davis")
val instructorMichael = Instructor("Michael Johnson")

// Students
val studentAlice = Student("Alice Brown")
val studentBob = Student("Bob Green")
val studentCharlie = Student("Charlie White")
val studentDiana = Student("Diana Black")
val studentHeshan = Student("Heshan Karunaratne")

// Lessons
val lessonMath = Lesson(
    instructor = instructorJohn,
    students = setOf(studentAlice, studentBob),
    rating = mapOf(studentAlice to 5, studentBob to 4)
)

val lessonScience = Lesson(
    instructor = instructorEmily,
    students = setOf(studentAlice, studentBob, studentDiana),
    rating = mapOf(studentAlice to 3, studentCharlie to 4, studentDiana to 5)
)

val lessonHistory = Lesson(
    instructor = instructorMichael,
    students = setOf(studentBob, studentCharlie),
    rating = mapOf(studentBob to 4, studentCharlie to 5)
)

// School
val school = School(
    instructors = setOf(instructorJohn, instructorEmily, instructorMichael),
    students = setOf(studentAlice, studentBob, studentCharlie, studentDiana, studentHeshan),
    lessons = sequenceOf(lessonMath, lessonScience, lessonHistory)
)

fun School.commonLessons(instructor: Instructor, student: Student): Sequence<Lesson> {
    return lessons.filter { lesson -> lesson.instructor == instructor && student in lesson.students }
}

fun School.studentInstructors(student: Student): Set<Instructor> {
    val filtered = lessons.filter { student in it.students }.toList()
    return filtered.map { it.instructor }.toSet()
}

fun School.studentsOf(instructor: Instructor): Set<Student> {
    val filtered = lessons.filter { instructor == it.instructor }
    return filtered.flatMap { it.students }.toSet()
}

fun School.averageInstructorRating(instructor: Instructor): Double {
    val filtered = lessons.filter { it.instructor == instructor }.toList()
    val flatted = filtered.flatMap { it.rating.values.asSequence() }.toList()
    return flatted.average()
}

fun School.favoriteInstructor(student: Student): Instructor? {
    val filtered = lessons.filter { student in it.students }.toList()
    val grouped = filtered.groupBy { it.instructor }
    val maxElement = grouped.maxByOrNull { (_, lessons) -> lessons.size }
    return maxElement?.key
}

fun School.instructorsWithLargestClass(): Set<Instructor> {
    val maxClassSize = lessons.map { it.students.size }.maxOrNull()
    return lessons.filter { it.students.size == maxClassSize }.map { it.instructor }.toSet()
}

fun main() {

    val commonLessons = school.commonLessons(instructorEmily, studentAlice).toList()
//    println(commonLessons)

    val studentInstructors = school.studentInstructors(studentAlice).toList()
//    println(studentInstructors)

    val studentsOf = school.studentsOf(instructorEmily).toList()
//    println(studentsOf)

    val averageInstructorRating = school.averageInstructorRating(instructorEmily)
//    println(averageInstructorRating)

    val favoriteInstructor = school.favoriteInstructor(studentBob)
//    println(favoriteInstructor)

    val instructorsWithLargestClass = school.instructorsWithLargestClass()
    println(instructorsWithLargestClass)
}