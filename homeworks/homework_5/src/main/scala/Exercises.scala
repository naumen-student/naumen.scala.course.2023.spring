object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+A <: Animal](animals: List[A]) {
    def +[B >: A <: Animal](animal: B): Shelter[B] = Shelter(animals :+ animal)

    def ++[B >: A <: Animal](other: Shelter[B]): Shelter[B] = Shelter(animals ++ other.animals)

    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[A]): List[String] = animals.map(animal => food.feed(animal))
  }


  trait Food[-A <: Animal] {
    def feed(animal: A): String
  }

  case object Meat extends Food[Animal] {
    override def feed(animal: Animal): String = s"${animal.name} eats meat"
  }

  case object Milk extends Food[Cat] {
    override def feed(cat: Cat): String = s"${cat.name} eats milk"
  }

  case object Bread extends Food[Dog] {
    override def feed(dog: Dog): String = s"${dog.name} eats bread"

  }
