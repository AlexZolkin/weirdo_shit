package chapter5.bank.log

trait Logged {
  def log(message: String)
  def info(message: String): Unit = log("INFO: " + message)
  def warn(message: String): Unit = log("WARN: " + message)
  def severe(message: String): Unit = log("SEVERE: " + message)
}
