package chapter10.shapes

import java.awt.geom.Ellipse2D

trait RectangleLike {
  this: Ellipse2D =>
  def translate(dx: Int, dy: Int): Unit = {
    setFrame(getX + dx, getY + dy, getWidth, getHeight)
  }

  def grow(dw: Int, dh: Int): Unit = {
    setFrame(getX, getY, getWidth + dw, getHeight + dh)
  }
}
