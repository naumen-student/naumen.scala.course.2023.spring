object Exercises {
  trait Animal {
    protected def name: String
  }

  case class Cat(name: String) extends Animal

  case class Dog(name: String) extends Animal

  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](animal: B): Shelter[B] = Shelter(animal :: animals)

    def ++[B >: A <: Animal](other: Shelter[B]): Shelter[B] = Shelter(animals ::: other.animals)

    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(animal => food.feed(animal))
  }

  trait Food[-T <: Animal] {
    val name: String
    def feed(animal: T): String = s"${animal.name} eats $name"
  }

  case object Meat extends Food[Animal] {
    val name: String = "meat"
  }

  case object Milk extends Food[Cat] {
    val name: String = "milk"
  }

  case object Bread extends Food[Dog] {
    val name: String = "bread"
  }
}
