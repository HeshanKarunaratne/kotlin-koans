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

// You can write lambdas in below way as well
fun fibonacci(): Sequence<Int> {
    var previous = 1
    return generateSequence(0) {
        val next = previous + it
        previous = it
        next
    }
}
```

#### Local Functions

```kt
val logMsg = StringBuilder()
fun log(message: String) = logMsg.appendLine(message)
log("Starting computation")
val x = 42
log("Computation result: $x")

// Local Extension
fun String.exclaim() = "$this!"
"Hello".exclaim() eq "Hello!"

// Local function reference
fun interesting(session: Session): Boolean {
    return session.title.contains("Kotlin")
}
sessions.any(::interesting) eq true
```

#### Folding Lists
```kt
val list = listOf(1, 10, 100, 1000)
list.fold(0) { sum, n -> sum + n } eq 1111

// Fold and FoldRight
val list2 = listOf('a', 'b', 'c', 'd')
list2.fold("*") { acc, elem -> "($acc) + $elem" } eq
        "((((*) + a) + b) + c) + d"
list2.foldRight("*") { elem, acc -> "$elem + ($acc)" } eq 
        "a + (b + (c + (d + (*))))"

// Reduce and ReduceRight
val chars = "A B C D E".split(" ")
chars.reduce { acc, e -> "$acc $e" } eq "A B C D E"
chars.reduceRight { e, acc -> "$acc $e" } eq "E D C B A"
```

##### Object Oriented Programming
#### Interfaces
```kt
// Functions
interface Computer {
  fun prompt(): String 
  fun calculateAnswer(): Int
}

class Desktop : Computer {
  override fun prompt() = "Hello!"
  override fun calculateAnswer() = 11
}

val computers = listOf(Desktop(), DeepThought(), Quantum())
computers.map { it.calculateAnswer() } eq "[11, 42, -1]"
computers.map { it.prompt() } eq "[Hello!, Thinking..., Probably...]"

// Property
interface Player {
    val symbol: Char
}

class Food : Player {
    override val symbol = '.'
}

// overriding as constructor parameter
class Wall(override val symbol: Char) : Player

// Enum overriding
interface Hotness {
    fun feedback(): String
}

enum class SpiceLevel : Hotness{
    Mild {
        override fun feedback() =
            "It adds flavor!"
    },
    Medium {
        override fun feedback() =
            "Is it warm in here?"
    }
}

// SAM - Single Abstract Method
fun interface OneArg {
    fun g(n: Int): Int
}

class VerboseOne : OneArg {
    override fun g(n: Int) = n + 47
}
val verboseOne = VerboseOne()
// You can pass a lambda as the argument
val samOne = OneArg { it + 47 }
```

#### Constructors
```kt
// If you are adding more secondary constructors it should go to the init constructor always
class WithSecondary(i: Int) {
  init {
    trace("Primary: $i")
  }
  constructor(c: Char) : this(c - 'A') {
    trace("Secondary char: '$c'")
  }
  constructor(s: String) :
    this(s.first()) {             // [1]
    trace("Secondary string: \"$s\"")
  }
}
```

#### Inheritance
```kt
// if a class is final or not open then it cannot be inherited
open class Base
class Derived : Base()

// Base Class initialization
open class SuperClass1(val i: Int)
class SubClass1(i: Int) : SuperClass1(i)
```

#### Abstract Classes
```kt
abstract class WithProperty {
    abstract val x: Int
}

abstract class WithFunctions {
    abstract fun f(): Int
}

// Interface is fully abstract class, so no need to define abstract keyword
// In Interface you can write a body as well
interface Parent {
    val ch: Char
    fun f(): Int
    fun g() = "ch = $ch; f() = ${f()}"
}

// Multiple Inheritance is achieved through interfaces
interface Animal
interface Mammal: Animal
interface AquaticAnimal: Animal

class Dolphin : Mammal, AquaticAnimal

// Polymorphism
open class Pet {
    open fun speak() = "Pet"
}
class Dog : Pet() {
    override fun speak() = "Bark!"
}
class Cat : Pet() {
    override fun speak() = "Meow"
}
fun talk(pet: Pet) = pet.speak()

// Composition
interface Building
interface Kitchen

interface House: Building {
    val kitchen1: Kitchen
    val kitchen2: Kitchen
}

// Inheritance and Extensions
fun Heater.cool(temperature: Int) =
    "cooling to $temperature"

fun warmAndCool(heater: Heater) {
    heater.heat(70) eq "heating to 70"
    heater.cool(60) eq "cooling to 60"
}
```

#### Class Delegation
```kt
interface Logger {
    fun log(message: String)
}

class ConsoleLogger : Logger {
    override fun log(message: String) {
        println("Console: $message")
    }
}

class AdvancedLogger(logger: Logger) : Logger by logger {
    fun logError(error: String) {
        log("ERROR: $error")
    }
}

fun main() {
    val consoleLogger = ConsoleLogger()
    val advancedLogger = AdvancedLogger(consoleLogger)
    consoleLogger.log("console logger")
    advancedLogger.log("This is a standard log message.")
    advancedLogger.logError("This is an error message.")
}
```

#### Downcasting
```kt
// When you upcast if any method that doesn't available in the superclass cannot be invoked with subclass 
val b1: Base = Derived1() // Upcast
if(b1 is Derived1){ // Downcast
    b1.g()
}

// Safe casting with as?
fun dogBarkSafe(c: Creature) =
    (c as? Dog)?.bark() ?: "Not a Dog"

fun main() {
    dogBarkSafe(Dog()) eq "Yip!"
    dogBarkSafe(Human()) eq "Not a Dog"
}

// Find
val group: List<Creature> = listOf(
    Human(), Human(), Dog(), Alien(), Dog()
)

val dog = group
    .find { it is Dog } as Dog?
dog?.bark() eq "Yip!"

// Filtering
val humans1: List<Creature> =
    group.filter { it is Human }
humans1.size eq 2
val humans2: List<Human> =
    group.filterIsInstance<Human>()
humans2 eq humans1
```

#### Sealed Classes
```kt
// All direct subclasses of a sealed class must be declared in the same file as the sealed class. This ensures that the set of subclasses is known and controlled.
sealed class Transport

data class Train(
    val line: String
) : Transport()

data class Bus(
    val number: String,
    val capacity: Int
) : Transport()

fun travel(transport: Transport) =
    when (transport) {
        is Train ->
            "Train ${transport.line}"
        is Bus ->
            "Bus ${transport.number}: " +
                    "size ${transport.capacity}"
        else -> ""
    }

listOf(Train("S1"), Bus("11", 90)).map(::travel) eq "[Train S1, Bus 11: size 90]"



```

#### Sealed vs Abstract classes
- Sealed classes restrict the subclasses to a single file, while abstract classes do not.
- Neither sealed nor abstract classes can be instantiated directly, but abstract classes are more flexible in terms of inheritance.
- Sealed classes are commonly used in scenarios where you have a known set of possible types (e.g., representing states or outcomes), while abstract classes are used to define a common interface or base class for related classes.

#### Lambdas
```text
Similarities Between Concrete, Abstract, Sealed Classes, and Interfaces

1. Inheritance: All four (concrete classes, abstract classes, sealed classes, and interfaces) can be used as super types for other classes or interfaces.
2. Type Safety: All four ensure type safety and help define contracts or hierarchies that are enforced at compile-time.
3. Default Implementations: All four can provide default method implementations. Abstract and concrete classes can do this with regular methods, while interfaces can do it using default methods.

Differences Between Concrete, Abstract, Sealed Classes, and Interfaces

1. Concrete Class
- A regular class that can be instantiated and used directly
- Can be inherited by other classes if marked as open
- Cannot be inherited by other classes if marked as final
- The inheriting class can override methods that are open for overriding

2. Abstract Class
- A class that cannot be instantiated directly. It can have both abstract (unimplemented) methods and concrete (implemented) methods
- Must be inherited by a subclass, which should provide implementations for the abstract methods
- Cannot add 'open' which is redundant and 'final' which is incompatible

3. Sealed Class
- A class that restricts inheritance. All subclasses must be defined in the same file.
- Can only be inherited within the same file where the sealed class is defined. The number of subclasses is known and controlled.
- Cannot be instantiated directly

4. Interface
- A contract that can be implemented by classes or other interfaces. It can declare abstract methods and properties, as well as provide default implementations.
- Can be implemented by any class, including abstract, sealed, or concrete classes, and can also extend other interfaces.
- Cannot be instantiated directly
```

#### Objects
```kt
// Define Objects
object JustOne {
    val n = 2
    fun f() = n * 10
    fun g() = this.n * 20
}

fun main() {
    // val x = JustOne() // Error
    JustOne.n eq 2
    JustOne.f() eq 20
    JustOne.g() eq 40
}

//Inheritance
open class Paint(val color: String) {
    open fun apply() = "Applying $color"
}

object Acrylic: Paint("Blue") {
    override fun apply() =
        "Acrylic, ${super.apply()}"
}

interface PaintPreparation {
    fun prepare(): String
}

object Prepare: PaintPreparation {
    override fun prepare() = "Scrape"
}

fun main() {
    Prepare.prepare() eq "Scrape"
    Paint("Green").apply() eq "Applying Green"
    Acrylic.apply() eq "Acrylic, Applying Blue"
}

// Object nesting - Object nesting refers to the practice of defining an object inside another object, class

//Helpful for organizing related singletons within a common namespace
object Outer {
    object Nested {
        val a = "Outer.Nested.a"
    }
}

//Useful for associating a singleton with a specific class.
class HasObject {
    object Nested {
        val a = "HasObject.Nested.a"
    }
}

//Allows for defining static-like members in a class
class MyClass {
    companion object {
        fun companionMethod() = "Hello from Companion Object"
    }
}

fun main() {
    Outer.Nested.a eq "Outer.Nested.a"
    HasObject.Nested.a eq "HasObject.Nested.a"
    println(MyClass.companionMethod())
}
```

#### Nested Classes
Nested classes are classes defined within another class. There are two types of nested classes: Regular nested classes and Inner classes.
```kt

// 1. Regular Nested Class: A regular nested class does not have a reference to the outer class instance. It behaves like a static nested class in Java
class Outer {
    private val outerProperty: String = "Outer Property"

    // Regular nested class
    class Nested {
        fun nestedFunction() = "Hello from Nested Class"
    }
}

// 2. An inner class has a reference to an instance of the outer class and can access its members. To define an inner class, use the inner keyword
class Outer2 {
    private val outerProperty: String = "Outer Property"

    fun outerFun(): String {
        return "Outer2.outerFun"
    }

    // Inner Class
    inner class Inner {
        fun innerFunction() = "Accessing: $outerProperty"
        fun innerFun() = outerFun()
    }
}

fun main() {
    val nested = Outer.Nested()
    println(nested.nestedFunction())


    val inner = Outer2().Inner()
    println(inner.innerFunction())
    println(inner.innerFun())
}
```

#### Companion Objects
Companion object is a way to create a singleton for a class. It allows you to define members (functions or properties) that are tied to the class rather than to instances of the class. A companion object can access the private members of the class and is used similarly to static members in Java

```kt
class MyClass {
    // A property in the companion object
    companion object {
        val myProperty: String = "Hello, Companion!"
        // A function in the companion object
        fun myFunction(): String {
            return "This is a function in the companion object"
        }
    }
}
fun main() {
    // Accessing the companion object's property
    println(MyClass.myProperty)
    // Accessing the companion object's function
    println(MyClass.myFunction())
}

// Default name Companion
class WithNamed {
    companion object Named {
        fun s() = "from Named"
    }
}

class WithDefault {
    companion object {
        fun s() = "from Default"
    }
}

fun main() {
    WithNamed.s() eq "from Named"
    WithNamed.Named.s() eq "from Named"
    WithDefault.s() eq "from Default"
    WithDefault.Companion.s() eq "from Default"
}
```

#### Exceptions
```kt
// Define Exceptions
class Exception1(val value: Int) : Exception("wrong value: $value")
capture {
    throw Exception1(13)
} eq "Exception1: wrong value: 13"
```

#### Check Instructions
```kt
// require
data class Month(val monthNumber: Int) {
  init {
    require(monthNumber in 1..12) {
      "Month out of range: $monthNumber"
    }
  }
}

Month(1) eq "Month(monthNumber=1)" 
capture { Month(13) } eq "IllegalArgumentException: Month out of range:13"

// requireNotNull
fun notNull(n: Int?): Int {
    requireNotNull(n) {             // [1]
        "notNull() argument cannot be null"
    }
    return n * 9                    // [2]
}

val n: Int? = null
capture { notNull(n) } eq "IllegalArgumentException: notNull() argument cannot be null"

// Nothing Type
fun later(s: String): String = TODO("later()")
capture { later("Hello") } eq "NotImplementedError: An operation is not implemented: later()"

// Lists of Nothing
val listNone: List<Nothing?> = listOf(null)
val ints: List<Int?> = listOf(null)
ints eq listNone

// Resource Cleanup
class Usable() : AutoCloseable {
    fun func() = trace("func()")
    override fun close() = trace("close()")
}

fun main() {
    Usable().use { it.func() }
    trace eq "func() close()"
}
```

#### Unit Tests
```kt
fun testFortyTwo2(n: Int = 42) {
  expect(n, "Incorrect,") { fortyTwo() }
}

testFortyTwo2()
capture { testFortyTwo2(43) } contains listOf("expected:", "<43> but was:", "<42>")

class SampleTest {
    @Test
    fun testFortyTwo() {
        expect(42, "Incorrect,") { fortyTwo() }
    }
}
```

#### Extension Lambdas
```kt
val va: (String, Int) -> String = { str, n -> str.repeat(n) + str.repeat(n) }
val vb: String.(Int) -> String = { this.repeat(it) + repeat(it) }

va("Vanbo", 2) eq "VanboVanboVanboVanbo"
"Vanbo".vb(2) eq "VanboVanboVanboVanbo"
vb("Vanbo", 2) eq "VanboVanboVanboVanbo"

// buildList and buildMap
val characters: List<String> = buildList {
    add("Chars:")
    ('a'..'d').forEach { add("$it") }
}

val charmap: Map<Char, Int> = buildMap {
    ('A'..'F').forEachIndexed { n, ch ->
        put(ch, n)
    }
}

characters eq "[Chars:, a, b, c, d]"
charmap eq "{A=0, B=1, C=2, D=3, E=4, F=5}"
```

#### Scoped Functions

```txt
1. let
Context object: it
Return value: Lambda result

2. run
Context object: this
Return value: Lambda result

3. with
Context object: this
Return value: Lambda result

4. apply
Context object: this
Return value: The object itself

5. also
Context object: it
Return value: The object itself
```

```kt
// let
val name: String = "Kotlin"
val result = name.let {
    println("Name length: ${it.length}")
    it.length
}

// run
val name2 = "Kotlin"
val result = name2.run {
    println("Name: $this")
    length // returns length
}

// with
val name3 = "Kotlin"
val result = with(name3) {
    println("Name is $this")
    length
}

// apply
class User() {
    var name: String = ""
    var age: Int = 0
}

val user = User().apply {
    name = "Alice"
    age = 30
}

// also
val name = "Kotlin".also {
    println("Name length is: ${it.length}")
}
```

#### Generics
```kt
// Type checking with inline reified
// inline: It helps in reducing overhead and enables special behaviors in generic functions, like type checking
// reified: When we use the reified keyword in an inline function, it allows us to check or access the type information of the generic parameter T at runtime

inline fun <reified T> check(t: Any) = t is T
check<String>("1") eq true
check<Int>("1") eq false


// Covariant Return Type
interface Parent
interface Child : Parent

interface  X {
    fun f(): Parent
}

interface Y : X {
    override fun f(): Child
}
```

#### Invariance, Contravariance. Covariance

1. Box<T> (Invariance)
- Invariance: The type parameter T is invariant, meaning that Box<T> can only work with a specific type T and cannot be used with a subtype or supertype of T

```kt
class Box<T>(private var contents: T) {
  fun put(item: T) { contents = item }
  fun get(): T = contents
}
```

2. InBox<in T> (Contravariance)
- Contravariance: The in keyword makes the type parameter T contravariant. This means that InBox<T> can accept objects of type T or any of its supertypes. However, you can only put items into the InBox, not get them

```kt
class InBox<in T>(private var contents: T) {
    fun put(item: T) { contents = item }
}
```

2. OutBox<in T> (Covariance)
- Covariance: The out keyword makes the type parameter T covariant. This means that OutBox<T> can return objects of type T or any of its subtypes. However, you can only retrieve items from the OutBox, not put them in.

```kt
class InBox<in T>(private var contents: T) {
    fun put(item: T) { contents = item }
}
```


#### Lambdas
```kt

```

