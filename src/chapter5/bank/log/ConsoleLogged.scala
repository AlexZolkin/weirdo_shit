package chapter5.bank.log

trait ConsoleLogged extends Logged {
  abstract override def log(message: String): Unit = println(message)
}
