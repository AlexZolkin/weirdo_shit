package chapter5

class Time(private var _hrs:Int, private var _min:Int) {
  _min = _min match {
    case i:Int if i%60==0 => _hrs += i/60; 0
    case i:Int if i<0 => _hrs += (i/60 - 1); 60 + i%60
    case i:Int if i>59 => _hrs += i/60; i%60
    case _ => _min
  }
  _hrs = _hrs match {
    case i:Int if i<0 => 24 + i%24
    case i:Int if i>23 => i%24
    case _ => _hrs
  }

  def hrs: Int = _hrs
  def min: Int = _min
  def before(other:Time): Boolean = {
    _hrs < other._hrs || (other._hrs == _hrs && _min < other._min)
  }
}