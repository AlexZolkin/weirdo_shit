package chapter5

import scala.collection.mutable.ArrayBuffer

class Network {
  class Member(val name: String){
    val contacts = new ArrayBuffer[Member]()
  }

  private val members = new ArrayBuffer[Member]()

  def join(name: String): Member ={
    val member = new Member(name)
    members += member
    member
  }
}
