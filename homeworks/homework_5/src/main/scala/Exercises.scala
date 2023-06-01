object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](container: List[T]) {
    def getNames = container map { _.name }
    def ++[B >: T <: Animal](other: Shelter[B]) = Shelter(
      container ++ other.container
    )
    def +[B >: T <: Animal](other: B) = Shelter(container :+ other)
    def feed(food: Food[T]) = container map { food.feed }
  }

  trait Food[-T <: Animal] {
    val food: String
    def feed(animal: T) = s"${animal.name} eats ${food}"
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
