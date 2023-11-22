object Exercises {
  trait Animal {
    def name: String
  }
  case class Cat(override val name: String) extends Animal
  case class Dog(override val name: String) extends Animal



  case class Shelter ...
  case class Shelter[+T <: Animal](animals: List[T]) {

    def +[TOther >: T <: Animal](newAnimal: TOther): Shelter[TOther] = Shelter(animals :+ newAnimal)

    def ++[TOther >: T <: Animal](other: Shelter[TOther]): Shelter[TOther] = Shelter(this.animals ++ other.animals)

  trait Food ...
    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[T]): List[String] = animals.map(x => food.feed(x))
  }

  case object Meat extends Food[Animal] ...

  case object Milk extends Food[Cat] ...

  case object Bread extends Food[Dog] ...
  trait Food[-T <: Animal] {
    val name: String
    def feed(animal: T): String = f"${animal.name} eats $name"
  }

  case object Meat extends Food[Animal] {
    override val name = "meat"
  }

  case object Milk extends Food[Cat] {
    override val name = "milk"
  }

  case object Bread extends Food[Dog] {
    override val name = "bread"
  }
}
