object Exercises {
  trait Animal {
    val name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+TAnimal <: Animal](animals: List[TAnimal]) {
    def +[TOtherAnimal >: TAnimal <: Animal](otherAnimal: TOtherAnimal): Shelter[TOtherAnimal] = Shelter(animals :+ otherAnimal)

    def ++[TOtherAnimal >: TAnimal <: Animal](otherShelter: Shelter[TOtherAnimal]): Shelter[TOtherAnimal] = Shelter(animals ++ otherShelter.animals)

    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[TAnimal]): List[String] = animals.map(food.feed)
  }

  trait Food[-TAnimal <: Animal] {
    val food: String

    def feed(animal: TAnimal): String = f"${animal.name} eats ${food}"
  }

  case object Meat extends Food[Animal] {
    override val food: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val food: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val food: String = "bread"
  }
}