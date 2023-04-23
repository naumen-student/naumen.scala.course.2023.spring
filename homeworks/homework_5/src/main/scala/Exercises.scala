object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](animal: B): Shelter[B] = Shelter(animals :+ animal)

    def ++[B >: A <: Animal](other: Shelter[B]): Shelter[B] = Shelter(animals ++ other.animals)

    def getNames: List[String] = animals.map(a => a.name)

    def feed(food: Food[A]): List[String] = animals.map(animal => food.feed(animal))
  }

  trait Food[-T <: Animal] {
    val name: String = "food



  trait Food ...

  case object Meat extends Food[Animal] ...

  case object Milk extends Food[Cat] ...

  case object Bread extends Food[Dog] ...
}
