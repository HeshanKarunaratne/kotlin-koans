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



#### Lambdas
```kt

```
