import java.util.TimeZone

import scala.collection.mutable.ArrayBuffer
import scala.collection.{SortedMap, mutable}

object Main extends App {
  def factorial(n: Int): Int = {
    var r = 1
    for (i <- 1 to n) r *= i
    r
  }

  def decorate(str: String, left: String = "{", right: String = "}") = {
    left + str + right
  }

  def sum(args: Int*): Int = {
    var result = 0
    for (arg <- args) result += arg
    result
  }

  def recursiveSum(args: Int*): Int = {
    if (args.isEmpty) 0
    else args.head + recursiveSum(args.tail: _*)
  }

  def box(s: String): Unit = {
    val border = "-" * s.length + "--\n"
    println(border + "|" + s + "|\n" + border)
  }

  def signum(number: Integer): Integer = {
    if (number > 0) return 1
    else if (number < 0) return -1
    0
  }

  def countDown(count: Integer): Unit = {
    for (i <- Range(count, 0).by(-1)) print(i + " ")
    println()
  }

  def unicodeCounter(string: String): Long = {
    var x: Long = 1
    for (symbol <- string) x *= symbol
    x
  }

  def unicodeCounterNoLoop(string: String): Long = {
    string.map(_.toLong).product
  }

  def product(s: String): Long = {
    var x: Long = 1
    for (symbol <- s) x *= symbol
    x
  }

  def productRecursive(s: String): Long = {
    if (s.isEmpty) 1
    else productRecursive(s.tail) * s.head.toLong
  }

  def recursivePow(number: Integer, power: Integer): Double = {
    var result: Double = 0
    if (power > 0 && power % 2 == 0) result = recursivePow(number, power / 2) * recursivePow(number, power / 2)
    if (power > 0 && power % 2 != 0) result = number * recursivePow(number, power - 1)
    if (power == 0) result = 1
    if (power < 0) result = 1 / recursivePow(number, -power)
    result
  }

  def removeNegativeElementsFromArrayExceptFirst(array: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var firstFlag = true
    val indexes = for (i <- array.indices if firstFlag || array(i) >= 0) yield {
      if (array(i) < 0) firstFlag = false
      i
    }
    for (i <- indexes.indices) array(i) = array(indexes(i))
    array.trimEnd(array.length - indexes.length)
    array
  }

  def createMatrix(col: Int, row: Int): Array[Array[Int]] = {
    val matrix = Array.ofDim[Int](col, row)
    matrix(col - 1)(row - 1) = col + row
    matrix
  }

  def arrayAndArrayBufferExamples(): Unit = {
    val array = Array("Hello", "World")
    array(0) = "Goodbye"
    println(array.mkString(" | "))
    println(array.mkString("<", " | ", ">"))
    val arrayBuffer = ArrayBuffer[Int]()
    arrayBuffer += 44
    arrayBuffer += (1, 2, 3, 4)
    arrayBuffer ++= Array(5, 6, 7, 35, 67)
    arrayBuffer.trimEnd(2)
    println(arrayBuffer.tail)
    for (i <- (0 until(arrayBuffer.length, 2)).reverse)
      println(i + ": " + arrayBuffer(i) + "\t")
    val doubledArrayBuffer = for (element <- arrayBuffer) yield 3 * element
    println(doubledArrayBuffer)
    var newDoubledArrayBuffer = doubledArrayBuffer.filter(_ % 2 == 0).map(2 * _)
    println(newDoubledArrayBuffer)
    newDoubledArrayBuffer = doubledArrayBuffer.filter {
      _ % 2 == 0
    } map {
      2 * _
    }
    println(newDoubledArrayBuffer)
  }

  def createArray(size: Int, startingIndex: Int = 0): Array[Int] = {
    Array(startingIndex until size + startingIndex: _*)
  }

  def mixPairsInArray(array: Array[Int]): Array[Int] = {
    for (i <- array.indices if i % 2 == 0) {
      val temp = array(i)
      try {
        array.update(i, array(i + 1))
        array.update(i + 1, temp)
      } catch {
        case _: ArrayIndexOutOfBoundsException => ()
      }
    }
    array
  }

  def mixPairsInArrayCreating(array: Array[Int]): Array[Int] = {
    (for (i <- array.indices) yield
      if (i % 2 == 0 && i + 1 == array.length) array(i)
      else if (i % 2 == 0) array(i + 1)
      else array(i - 1)).toArray
  }

  def sortPositive(array: Array[Int]): Array[Int] = {
    array.filter(_ > 0) ++ array.filter(_ <= 0)
  }

  def countAverage(array: Array[Double]): Double = {
    array.sum / array.length
  }

  def reverseArray(array: Array[Int]): Array[Int] = {
    array.reverse.array
  }

  def reverseArrayBuffer(array: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    array.reverse
  }

  def removeDoubledElements(array: Array[Int]): Array[Int] = {
    array.distinct
  }

  def removeNegativesButFirst(array: Array[Int]): Array[Int] = {
    val newArray = for (i <- array.indices if i <= array.indexWhere(_ > 0) || array(i) > 0) yield array(i)
    newArray.toArray
  }

  def getCountryTimeZonesSorted(prefix: String): Array[String] = {
    TimeZone.getAvailableIDs filter {
      _ startsWith prefix
    } map {
      _ stripPrefix prefix
    } sorted
  }

  def cortegExamples(): Unit = {
    val t = (1, 3.14, "Fred", 'c')
    println(t._1 + t._2)
    val (first, second, third, _) = t
    val fourth = t._4
    println(first + second + third + fourth)
    println("Hello, World!".partition(_.isUpper))
    for ((symbol, count) <- Array("<", "-", ">").zip(Array(2, 10, 3)))
      print(symbol * count)
    println()
  }

  def discountMaps(): Unit = {
    val originalMap = Array("1", "2", "3", "4").zip(Array(10.0, 11.0, 12.0, 13.0)).toMap
    println(originalMap.mkString("\\") + " | " + originalMap.getClass.getSimpleName)
    val newMap = for ((key, value) <- originalMap) yield (key, value * 0.9)
    println(newMap.mkString("\\") + " | " + newMap.getClass.getSimpleName)
  }

  def wordCounter(): Unit = {
    val exampleString = "some words, more words, some more words"
    val map = new mutable.HashMap[String, Int]
    exampleString.split("\\W+").foreach(word => map(word) = map.getOrElse(word, 0) + 1)
    println(map.mkString("|"))
  }

  def wordCounterImmutable(): Unit = {
    val exampleString = "some words, more words, some more words"
    val words = exampleString.split("\\W+")
    val map = SortedMap[String, Int]() ++ (for (word <- words.distinct) yield (word, words.count(_ == word))).toMap
    println(map.mkString("|"))
  }

  def minMax(values: Array[Int]): (Int, Int) = {
    (values.min, values.max)
  }

  def lessMoreEqualCount(values: Array[Int], v: Int): (Int, Int, Int) = {
    (values.count(_ < v), values.count(_ == v), values.count(_ > v))
  }

  def compareStringsByTuples(first: String, second: String): Boolean = {
    first.zip(second).count(tuple => tuple._1 == tuple._2) == first.length
  }

  println(factorial(10))
  println(decorate("hello"))
  println(decorate("hello", "<<<"))
  println(decorate(str = "hello", right = ">>>>"))
  println(sum(1 to 5: _*))
  println(recursiveSum(2 to 6: _*))
  box("Hello, World!")
  countDown(10)
  println(unicodeCounter("Hello"))
  println(unicodeCounterNoLoop("Hello"))
  println(productRecursive("Hello"))
  println(recursivePow(3, -1))
  arrayAndArrayBufferExamples()
  println(removeNegativeElementsFromArrayExceptFirst(ArrayBuffer(1, 2, -4, 5, -6, 8, -9)))
  println(createMatrix(5, 6)(4)(5))
  println(mixPairsInArray(createArray(5)).mkString("|"))
  println(mixPairsInArrayCreating(createArray(6)).mkString("|"))
  println(sortPositive(createArray(startingIndex = -10, size = 20)).mkString("|"))
  println(reverseArray(createArray(10)).mkString("|"))
  println(removeDoubledElements(createArray(10) ++ createArray(10)).mkString("|"))
  println(getCountryTimeZonesSorted("America/").mkString("|"))
  private var stringToInt = mutable.Map("Alice" -> 10, "Bob" -> 15)
  println(stringToInt getOrElse("Bob", 0))
  stringToInt("Bob") = 12
  stringToInt("Fred") = 11
  stringToInt += ("Mike" -> 16, "Josh" -> 17)
  stringToInt -= "Alice"
  println(stringToInt)
  cortegExamples()
  discountMaps()
  wordCounter()
  wordCounterImmutable()
  println(minMax(Array(3, 8, -1)))
  println(lessMoreEqualCount(Array(1 to 10: _*), 5))
  println((compareStringsByTuples("Hello", "Hello"), compareStringsByTuples("Hello", "World")))
}
