case class Shelter[+A <: Animal](animals: List[A]) {
  def +[B >: A <: Animal](animal: B): Shelter[B] = Shelter(animals :+ animal)

  def ++[B >: A <: Animal](other: Shelter[B]): Shelter[B] = Shelter(animals ++ other.animals)

  def getNames: List[String] = animals.map(_.name)

  def feed(food: Food[A]): List[String] = animals.map(animal => food.feed(animal))
}
