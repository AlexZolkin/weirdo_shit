package chapter5.converter

object GallonsToLiters extends UnitConversation {
  override def convert(originValue: Double): Double = {
    originValue * 3.79
  }
}
