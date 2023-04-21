object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](OtherAnimal: B): Shelter[B] = Shelter(animals :+ OtherAnimal)

    def ++[B >: A <: Animal](otherShelter: Shelter[B]): Shelter[B] = Shelter(animals ++ otherShelter.animals)

    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(animal => food.feed(animal))
  }


  trait Food[-T <: Animal] {
    val name: String = "food"

    def feed(animal: T): String = animal.name + " eats " + this.name
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
