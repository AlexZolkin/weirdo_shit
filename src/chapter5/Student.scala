package chapter5

import scala.beans.BeanProperty

class Student(@BeanProperty name: String, @BeanProperty var id: Long) {

}
