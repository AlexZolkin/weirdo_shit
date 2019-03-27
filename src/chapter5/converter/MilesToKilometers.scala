package chapter5.converter

object MilesToKilometers extends UnitConversation {
  override def convert(originValue: Double): Double = {
    originValue * 1.6
  }
}
