package chapter5.bank

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amountToAdd: Double): Double = super.deposit(amountToAdd - 1)

  override def withdraw(amountToWithdraw: Double): Double = super.withdraw(amountToWithdraw + 1)
}
