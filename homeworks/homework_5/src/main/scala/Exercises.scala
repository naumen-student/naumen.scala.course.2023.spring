object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+T <: Animal](list: List[T]) {
    def +[A >: T <: Animal](animal: A): Shelter[A] = Shelter(list :+ animal)

    def ++[A >: T <: Animal](shelter: Shelter[A]): Shelter[A] = {
      val listA: List[A] = list
      Shelter(listA ++ shelter.list)
    }

    def getNames: List[String] = list.map(_.name)


  }



  trait Food ...

  case object Meat extends Food[Animal] ...

  case object Milk extends Food[Cat] ...

  case object Bread extends Food[Dog] ...
}
