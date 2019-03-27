package chapter5.bank.log

import java.util.Date

trait TimestampLogged extends Logged {
   abstract override def log(message: String): Unit = {
    super.log(new Date() + " " + message)
  }
}
