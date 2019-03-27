package chapter10

import java.awt.geom.Ellipse2D

import chapter10.shapes.RectangleLike

object Chapter10Ex extends App {
  val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  egg.translate(10, -10)
  egg.grow(10, 20)
  println(egg.getHeight + "|" + egg.getWidth)
}
