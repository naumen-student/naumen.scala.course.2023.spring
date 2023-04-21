object Exercises {

  trait Animal {
    def name: String
  }

  trait Food[-A <: Animal] {
    val name: String

    def feed(animal: A) = s"${animal.name} eats $name"
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](animal: B): Shelter[B] = Shelter(animal :: animals)

    def ++[B >: A <: Animal](shelter2: Shelter[B]): Shelter[B] = Shelter(animals ::: shelter2.animals)

    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(food.feed)

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