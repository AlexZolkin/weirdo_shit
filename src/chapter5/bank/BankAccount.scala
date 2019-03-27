package chapter5.bank

class BankAccount(private var _balance: Double = 0.0) {

  def balance: Double = _balance

  def deposit(amountToAdd: Double): Double = {
    _balance += amountToAdd
    balance
  }

  def withdraw(amountToWithdraw: Double): Double = {
    if(balance - amountToWithdraw > 0) _balance -= amountToWithdraw
    balance
  }
}
