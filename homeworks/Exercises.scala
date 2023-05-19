import javax.print.attribute.standard.MediaSize.Other
object Exercises {
  trait Animal {
    def name: String
  }

  case class Shelter[+T <: Animal](animals: List[T]) {
    def +[S >: T <: Animal](other: S): Shelter[S] = Shelter(animals :+ other)

    def ++[S >: T <: Animal](other: Shelter[S]): Shelter[S] = Shelter(animals ++ other.animals)

    def feed(food: Food[T]): List[String] = animals.map(a => food.feed(a))

  def getNames: List[String] = animals.map(a => a.name)}



  trait Food[-T <: Animal] {
    val foodName: String = "food"

    def feed(animal: T): String = s"${animal.name} eats ${foodName}"
  }

  case object Meat extends Food[Animal] {
    override val foodName = "meat"
  }

  case object Milk extends Food[Cat] {
    override val foodName = "milk"
  }

  case object Bread extends Food[Dog] {
    override val foodName = "bread"
  }
}
