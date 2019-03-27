package chapter5.bank

import chapter5.bank.log.Logged

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) with Logged {
  private val interest = 0.02
  private var counter = 0

  def earnMonthlyInterest(): Unit ={
    counter = 0
    val amountToEarn = if(counter > 2) super.balance * interest - 1 else super.balance * interest
    super.deposit(amountToEarn)
  }

  override def deposit(amountToAdd: Double): Double = {
    counter += 1
    if(counter > 3) super.deposit(amountToAdd - 1) else super.deposit(amountToAdd)
  }

  override def withdraw(amountToWithdraw: Double): Double = {
    if(amountToWithdraw <= super.balance){
      counter += 1
      if(counter > 3) super.withdraw(amountToWithdraw + 1) else super.withdraw(amountToWithdraw)
    } else severe("Insufficient funds")
    0.0
  }

  override def log(message: String): Unit = println(message)
}
