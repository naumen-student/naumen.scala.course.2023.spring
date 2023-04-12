object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](private val animals: List[T] = List[T]()) {
    def +[T1 >: T <: Animal](animal: T1): Shelter[T1] = Shelter(animals :+ animal)

    def ++[T1 >: T <: Animal](shelter: Shelter[T1]): Shelter[T1] = Shelter(animals ++ shelter.animals)

    def getNames: Seq[String] = animals.map(_.name)

    def feed(food: Food[T]): Seq[String] = animals.map(food.feed)
  }

  trait Food[-T <: Animal] {
    def feed(animal: T): String
  }

  case object Meat extends Food[Animal] {
    override def feed(animal: Animal) = s"${animal.name} eats meat"
  }

  case object Milk extends Food[Cat] {
    override def feed(animal: Cat) = s"${animal.name} eats milk"
  }

  case object Bread extends Food[Dog] {
    override def feed(animal: Dog) = s"${animal.name} eats bread"
  }
}
