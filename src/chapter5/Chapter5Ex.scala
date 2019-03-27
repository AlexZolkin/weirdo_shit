package chapter5

import chapter5.bank.log.{ShortLogged, TimestampLogged}
import chapter5.bank.{BankAccount, SavingsAccount}
import chapter5.item.{Bundle, Item, SimpleItem}

import scala.collection.mutable.ArrayBuffer

object Chapter5Ex extends App {
  val myCounter: Counter = new Counter
  myCounter.increment()
  println(myCounter.current)

  val myPerson: Person = Person("Fred Smith")
  myPerson.age = 30
  myPerson.age = 21
  println(Person.displayData(myPerson))
  innerClassExample()
  val bankAccount: BankAccount = new BankAccount(100)
  bankAccount.deposit(30.0)
  bankAccount.withdraw(40.0)
  println(bankAccount.balance)
  val savingsAccount: SavingsAccount = new SavingsAccount(100) with TimestampLogged with ShortLogged {
    override val maxLength: Int = 23
  }
  for (i <- 1 to 10) savingsAccount.deposit(10)
  println(savingsAccount.balance)
  savingsAccount.earnMonthlyInterest()
  println(savingsAccount.balance)
  savingsAccount.withdraw(1000)
  for (i <- 1 to 3) savingsAccount.deposit(10)
  println(savingsAccount.balance)
  val array: ArrayBuffer[Item] = ArrayBuffer()
  for (i <- 0 to 5) array += new SimpleItem(i, "Item #" + i)
  val bundle: Bundle = new Bundle(array)
  println(bundle.price + "|" + bundle.description)


  def innerClassExample(): Unit ={
    val chatter = new Network
    val myFace = new Network

    val fred = chatter.join("Fred")
    val wilma = chatter.join("Wilma")
    fred.contacts += wilma

    val barney = myFace.join("Barney") //Can't join with prev, type mismatch
//    fred.contacts += barney  // Network# to contacts type needs adding if want to join
  }
}
