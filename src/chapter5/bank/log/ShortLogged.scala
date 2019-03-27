package chapter5.bank.log

trait ShortLogged extends Logged {
  val maxLength: Int

  abstract override def log(message: String): Unit = {
    super.log(if (message.length > maxLength) message.substring(0, maxLength) else message)
  }
}
