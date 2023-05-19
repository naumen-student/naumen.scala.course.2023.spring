object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T<:Animal](list: List[T]){
    def +[A>:T<:Animal](animal: A): Shelter[A] = Shelter(list :+ animal)
    def ++[A>:T<:Animal](shelter: Shelter[A]): Shelter[A] = {
      val listA: List[A] = list
      Shelter(listA ++ shelter.list)
    }
    def getNames: List[String] = list.map(_.name)
    def feed[A>:T<:Animal](food: Food[A]): List[String] = list.map(food.feed)
  }

  trait Food[T<:Animal]{
    val foodName: String
    def feed(animal: T): String = s"${animal.name} eats ${foodName.toLowerCase}"
  }

  case object Meat extends Food[Animal] {
    override val foodName: String = "Meat"
  }

  case object Milk extends Food[Cat] {
    override val foodName: String = "Milk"
  }

  case object Bread extends Food[Dog] {
    override val foodName: String = "Bread"
  }
}
