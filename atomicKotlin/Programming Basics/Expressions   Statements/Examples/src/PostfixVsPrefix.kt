// ExpressionsStatements/PostfixVsPrefix.kt

fun main() {
  var i = 10
  println(i++)
  println(i)
  var j = 20
  println(++j)
  println(j)


  var a = 10
//  println(a++ + a + ++a + a + a++) //57
//  println(a-- + ++a + a + ++a + a-- + a + ++a) //73

}
/* Output:
10
11
21
21
*/