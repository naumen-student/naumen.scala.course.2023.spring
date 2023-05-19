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