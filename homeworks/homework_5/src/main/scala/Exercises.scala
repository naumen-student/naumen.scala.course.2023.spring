object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](animals : List[T]) {
    def getNames: List[String] = animals.map(a => a.name)

    def feed(food: Food[T]): List[String] = animals.map(a => food.feed(a))

    def +[TPlus >: T <: Animal](animal: TPlus): Shelter[TPlus] = Shelter(animals :+ animal)

    def ++[TPlus >: T <: Animal](shelter: Shelter[TPlus]): Shelter[TPlus] = Shelter(animals ::: shelter.animals)
  }



  trait Food[-T <: Animal]{
    override def toString: String = this.getClass
      .getSimpleName
      .dropRight(1) // drops $ at end, stackoverflow 41570148 for more info
      .toLowerCase

    def feed(animal: T): String = s"${animal.name} eats ${this.toString}"
  }

  case object Meat extends Food[Animal]

  case object Milk extends Food[Cat]

  case object Bread extends Food[Dog]
}