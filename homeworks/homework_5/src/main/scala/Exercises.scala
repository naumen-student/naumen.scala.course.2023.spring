object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+A <: Animal](animals: List[A]) {
    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(food.feed)

    def +[B >: A <: Animal](animal: B): Shelter[B] = Shelter(animals :+ animal)

    def ++[B >: A <: Animal](shelter: Shelter[B]): Shelter[B] = Shelter(animals ::: shelter.animals)
  }

  trait Food[-A <: Animal] {
    val name: String

    override def toString: String = name

    def feed(animal: A): String = s"${animal.name} eats $name"
  }

  case object Meat extends Food[Animal] {
    override val name: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val name: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val name: String = "bread"
  }
}