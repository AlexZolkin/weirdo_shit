package chapter5.item

import scala.collection.mutable.ArrayBuffer

class Bundle(val items: ArrayBuffer[Item]) extends Item {
  override def price: Double = {
    items.map(_.price).sum
  }

  override def description: String = {
    items.map(_.description).mkString("|")
  }

  def addElement(itemToAdd: Item): Unit ={
    items += itemToAdd
  }
}
