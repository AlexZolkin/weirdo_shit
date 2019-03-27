package chapter5

class Counter {
  private var value = 0

  def increment(): Unit = {
    if(value < Int.MaxValue) value += 1
  }

  def current: Int = value
  def isLess(otherCounter: Counter): Boolean = value < otherCounter.value
}
