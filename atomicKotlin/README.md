# AtomicKotlinCourse

#### Lists

```kt


// Creating a list
val list = listOf(99, 3, 5, 7, 11, 13)
val list2: List<Int> = listOf(1, 2, 3)
val list3 = mutableListOf<Int>(99, 3, 5, 7, 11, 13)
val list2 = List(10) { it }
val list2 = List(10) { 0 }
// Getting from index
list[4] eq 11

// Adding elements
list3.add(4)
list3 += 4
list3 += listOf(5, 6)

// Useful methods
list.sum()
list.sorted()
list.reversed()
list.first()
list.takeLast(2)
list.chunked(3)
list.getOrNull(index = 0)
list.lastIndex
list.indices
list.filterNotNull()
list.drop(1)

// Looping
val list4 = listOf('a', 'b', 'c')
for ((index, value) in list4.withIndex()) {
    println("$index:$value")
}

// Predicates
val list5 = listOf(-3, -1, 5, 7, 10)
list5.count { it > 0 } eq 3
list5.find { it > 0 } eq 5
list5.firstOrNull { it > 0 } eq 5
list5.lastOrNull { it < 0 } eq -1
list5.any { it > 0 } eq true
list5.any { it != 0 } eq true
list5.all { it > 0 } eq false
list5.all { it != 0 } eq true
list5.none { it > 0 } eq false
list5.none { it == 0 } eq true

// Partitioning
val list6 = listOf(-3, -1, 5, 7, 10)
val (pos, neg) = list6.partition { it > 0 }
pos eq "[5, 7, 10]"
neg eq "[-3, -1]"

// Manipulating Lists
val left = listOf("a", "b", "c", "d")
val right = listOf("q", "r", "s", "t")
left.zip(right) eq "[(a, q), (b, r), (c, s), (d, t)]"
(10..100).zip(right) eq "[(10, q), (11, r), (12, s), (13, t)]"

data class Person(
    val name: String, val id: Int
)

val names = listOf("Bob", "Jill", "Jim")
val ids = listOf(1731, 9274, 8378)
names.zip(ids) { name, id ->
    Person(
        name, id
    )
} eq "[Person(name=Bob, id=1731), " + "Person(name=Jill, id=9274), " + "Person(name=Jim, id=8378)]"

left.zipWithNext() eq listOf(
    Pair('a', 'b'), Pair('b', 'c'), Pair('c', 'd')
)
left.zipWithNext { a, b -> "$a $b" } eq "[a b, b c, c d]"

// Flatten and flatMap
val flat = listOf(listOf(1, 2), listOf(4, 5), listOf(7, 8))
flat.flatten() eq "[1, 2, 4, 5, 7, 8]"

class Book(val title: String, val authors: List<String>)

val books = listOf(Book("1984", listOf("George Orwell")), Book("Ulysses", listOf("James Joyce")))
books.map { it.authors }.flatten() eq listOf("George Orwell", "James Joyce")
books.flatMap { it.authors } eq listOf("George Orwell", "James Joyce")
// map{ } and flatten() is equal to calling flatMap{ }

```

#### Sets

```kt
// Creating a set
val set = setOf(1, 1, 2, 3, 9, 9, 4)
val set2 = mutableSetOf<Int>()

// Set membership
(9 in set)
set.contains(9)

// Adding/Removing elements
set2 += 42
set2 -= 42

// Useful methods
set.union(setOf(3, 4, 5, 6))
set intersect setOf(0, 1, 2, 7, 8)
set subtract setOf(0, 1, 9, 10)
set - setOf(0, 1, 9, 10)

// List to Set
val list = listOf(3, 3, 2, 1, 2)
list.toSet()
list.distinct()
"abbcc".toSet()

val set3 = setOf("a", "ab", "ac")
set3.maxByOrNull { it.length }?.length eq 2
set3.filter { it.contains('b') } eq listOf("ab")
set3.map { it.length } eq listOf(1, 2, 2)
```

#### Maps

```kt
// Creating a map
val constants = mapOf("Pi" to 3.141, "e" to 2.718, "phi" to 1.618)
val m = mutableMapOf(5 to "five", 6 to "six")
val m2 = mapOf(5 to "five", 6 to "six")
val m3 = m2 + (4 to "four") // creating a new map but you cant add elements later

// Adding elements
m[5] = "5ive"
m += 4 to "four"

// Looking up with a key
constants["e"]
m2[5]
m.getOrDefault(0, "zero") // if key 0 exists gives the value, else gives the default value specified

// Useful methods
constants.keys
constants.values
constants.size
constants.getValue(name)

// Looping
val map = mapOf(1 to "one", 2 to "two")
for ((key, value) in map) {
    println("$key = $value,")
}

// NullMap
val nullMap = mapOf(0 to "yes", 1 to "no")
nullMap[2] eq null

// Manipulating Maps
val groupMap: Map<Int, List<Person>> = people().groupBy(Person::age)
groupMap[15] eq listOf(Person("Arthricia", 15))
groupMap[22] eq null

people().filter { it.name.first() == 'A' } eq listOf(Person("Alice", 21))
people().partition { it.name.first() == 'A' }
eq Pair (listOf(Person("Alice", 21)) listOf(Person("Bob", 25)))

// AssociatedWith
val mapAssociateWith: Map<Person, String> =
    people().associateWith { it.name }
mapAssociateWith eq mapOf(Person("Alice", 21) to "Alice")

// AssociatedBy
val mapAssociateBy: Map<String, Person> =
    people().associateBy { it.name }
mapAssociateBy eq mapOf("Alice" to Person("Alice", 21))

// GetOrPut and GetOrElse
val getOrElseMap = mutableMapOf<Int, String>(1 to "one", 2 to "two")
getOrElseMap.getOrElse(0) { "zero" } eq "zero"
getOrElseMap.getOrPut(0) { "zero" } eq "zero"
getOrElseMap eq "{1=one, 2=two, 0=zero}"

// FilterKeys and FilterValues
getOrElseMap.filterKeys { it % 2 == 1 } eq "{1=one}"
getOrElseMap.filterValues { it.contains('w') } eq "{2=two}"

map.any { (key, _) -> key < 0 } eq false
map.all { (key, _) -> key < 0 } eq false
map.maxByOrNull { it.key }?.value eq "two"

// Transforming maps
val even = mapOf(2 to "two", 4 to "four")
even.map { (key, value) -> "$key:$value" } eq listOf("2:two", "4:four")
even.mapKeys { (num, _) -> -num }
    .mapValues { (_, str) -> "minus $str" } eq mapOf(-2 to "minus two", -4 to "minus four")
```

#### Default Property accessors

```kt
class Default {
  var i: Int = 0
    get() {
      return field
    }
    set(value) {
      field = value
    }
}
```

##### Extension

#### Extension Functions
```kt
fun String.singleQuote() = "'$this'"
fun String.doubleQuote() = "\"$this\""

"Hi".singleQuote() eq "'Hi'"
"Hi".doubleQuote() eq "\"Hi\""
```

#### Extension Overloading
```kt
class My {
    fun foo() = 0
}
fun My.foo(i: Int) = i + 2 
fun My.foo(i: String) = i+i

fun main() {
    My().foo() eq 0
    My().foo(1) eq 3
    My().foo("hk") eq "hkhk"
}
```

#### Nullable Extension
```kt
fun String?.isNullOrEmpty(): Boolean =
    this == null || isEmpty()

fun main() {
    "".isNullOrEmpty() eq true
    null.isNullOrEmpty() eq true
}
```

#### Generic Class
```kt
class GenericHolder<T>(private val value: T) {
    fun getValue(): T = value
}

val h1 = GenericHolder(Automobile("Ford"))
h1.getValue()

val h2 = GenericHolder(1)
h2.getValue()
```

#### Generic Function
```kt
fun <T> identity(arg: T): T = arg
identity("Yellow") eq "Yellow"
```

#### Generic List Extension
```kt
fun <T> List<T>.first(): T {
    if (isEmpty())
        throw NoSuchElementException("Empty List")
    return this[0]
}
listOf(1, 2, 3).first()
```

#### Extension Properties
```kt
val String.indices: IntRange
    get() = 0 until length

"abc".indices eq 0..2
//
val <T> List<T>.firstOrNull: T?
    get() = if (isEmpty()) null else this[0]

listOf(1, 2, 3).firstOrNull eq 1
listOf<String>().firstOrNull eq null
```

#### Lambdas
```kt
val result = list.map { n: Int -> "[$n]" }
val result = list.map({ "[$it]" })
val result = list.map { "[${it.uppercaseChar()}]" }

val list2 = listOf('a', 'b', 'c')
val twoArgsLambda = list2.mapIndexed { index, el -> "[$index: $el]" }

val even = list.filter { it % 2 == 0 }

// By Operation
val products = listOf(
    Product("bread", 2.0),
    Product("wine", 5.0)
)
products.sumOf { it.price } eq 7.0
products.sortedByDescending { it.price } eq
        "[Product(description=wine, price=5.0)," +
        " Product(description=bread, price=2.0)]"
products.minByOrNull { it.price } eq
        Product("bread", 2.0)
```

#### Member Reference
```kt
val messages = listOf(
    Message("Kitty", "Hey!", true),
    Message("Kitty", "Where are you? **", false))
val unread = messages.filterNot(Message::isRead) //property reference

messages.sortedWith(compareBy(Message::isRead, Message::sender))

fun main(){
    // Function reference
    fun Message.isImportant(): Boolean =
        text.contains("Salary increase") || attachments.any {
            it.type == "image" && it.name.contains("cat") }
    messages.any(Message::isImportant) eq true
}

// Constructor Reference
data class Student(
    val id: Int,
    val name: String
)

val names = listOf("Alice", "Bob")
val students = names.mapIndexed { index, name -> Student(index, name) }
students eq listOf(Student(0, "Alice"), Student(1, "Bob"))
names.mapIndexed(::Student) eq students
//
```

#### Extension Reference
```kt
class Frog
fun goInt(n: Int, g: (Int) -> Int) = g(n) // Extension Reference
fun goFrog(frog: Frog, g: (Frog) -> String) = g(frog) // Extension Reference

fun main() {
    fun Int.times47() = times(47) //Extension function
    fun Frog.speak() = "Ribbit!"  //Extension function
    
    goInt(12, Int::times47) eq 564  // Function
    goFrog(Frog(), Frog::speak) eq "Ribbit!" // Functions
}
```

#### Nyllable Returns
```kt
val transform: (String) -> Int? = { s: String -> s.toIntOrNull() }

fun main() {
    transform("112") eq 112
    transform("abc") eq null
    val x = listOf("112", "abc")
    x.mapNotNull(transform) eq "[112]"
    x.mapNotNull { it.toIntOrNull() } eq "[112]"
}
```

#### Sequences
```kt
// Eager evaluation is immediate and generates intermediate collections.
val commonList = listOf(1, 2, 3, 4, 5)
val eagerResult = commonList.filter { it % 2 == 0 }.map { it * 2 }

// Lazy evaluation (using sequences) delays the computation until the final result is needed, which can improve performance by avoiding the creation of intermediate collections.
val lazyResult = commonList.asSequence()
    .filter { it % 2 == 0 }
    .map { it * 2 }
    .toList()
```

#### Generate Sequences
```kt
//seed value is starting value
val sequence = generateSequence(1) { it + 1 }.take(10).toList()
sequence.take(3).toList() eq listOf(1, 2, 3)

// This is like writing a for loop that starts from 6 that goes down to 0
generateSequence(6) { (it - 1).takeIf { it >= 0 } }.toList()
eq listOf (6, 5, 4, 3, 2, 1, 0)
```

#### Lambdas
```kt

```