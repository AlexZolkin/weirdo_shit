package chapter5

class Person(val privateName: String = "", private var privateAge: Int = 0) {
  private val firstName: String = privateName.split("\\W+")(0)
  private val lastName: String = privateName.split("\\W+")(1)
  privateAge = if (privateAge > 0) privateAge else 0

  def age: Int = privateAge

  def age_=(newAge: Int) {
    if (newAge > privateAge) privateAge = newAge
  }
}

object Person {
  def apply(name:String = "", age:Int = 0) = new Person(name, age)

  def displayData(person: Person): String={
    person.firstName + person.lastName + person.age
  }
}
