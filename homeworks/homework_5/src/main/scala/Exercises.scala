object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](private val animals: Iterable[T]) {
    val animalsList: List[T] = animals.toList

    def +[TOther >: T <: Animal](newAnimal: TOther): Shelter[TOther] = {
      Shelter(animalsList :+ newAnimal)
    }

    def ++[TOther >: T <: Animal](other: Shelter[TOther]): Shelter[TOther] = {
      Shelter(this.animalsList ++ other.animalsList)
    }

    def getNames: Iterable[String] = {
      animalsList.map(e => e.name)
    }

    def feed[TFood >: T](food: Food[TFood]): Iterable[String] = {
      animalsList.map(e => food.feed(e))
    }
  }



  trait Food[-T] {
    def feed(animal: T): String
  }

  case object Meat extends Food[Animal] {
    def feed(animal: Animal): String = {
      f"${animal.name} eats meat"
    }
  }

  case object Milk extends Food[Cat] {
    def feed(animal: Cat): String = {
      f"${animal.name} eats milk"
    }
  }

  case object Bread extends Food[Dog] {
    def feed(animal: Dog): String = {
      f"${animal.name} eats bread"
    }
  }
}
