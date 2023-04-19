object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter [+A <: Animal] (animals: List[A]) {
    def +[B >: A <: Animal](otherAnimals: B):Shelter[B] = Shelter(animals :+ otherAnimals)

    def ++[B >: A <: Animal](otherShelter: Shelter[B]):Shelter[B] = Shelter(animals ++ otherShelter.animals)

    def getNames:List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(food.feed)
  }



  trait Food [-A <: Animal] {
    val food : String

    def feed(animal : A) = s"${animal.name} eats $food"
  }


  case object Meat extends Food[Animal] {
    override val food = "meat"
  }

  case object Milk extends Food[Cat] {
    override val food = "milk"
  }

  case object Bread extends Food[Dog] {
    override val food = "bread"
  }
}
