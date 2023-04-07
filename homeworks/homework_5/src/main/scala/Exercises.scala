object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter ...



  trait Food ...

  case object Meat extends Food[Animal] ...

  case object Milk extends Food[Cat] ...

  case object Bread extends Food[Dog] ...
}
