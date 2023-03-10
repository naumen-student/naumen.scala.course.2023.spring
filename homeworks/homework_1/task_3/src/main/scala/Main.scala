object Main extends App {
  val name = "Sabrikhanov Ildar"
  val greetings = List("Hello", "Halo", "Guten tag")

  def printGreetings(): Unit = {
    greetings.foreach(
      greeting => println(greeting + " Scala! This is " + name)
    )
  }

  def printGreetingsWithReversedName(): Unit = {
    greetings.foreach(
      greeting => println(greeting + " Scala! This is " + name.reverse)
    )
  }

  printGreetings()
  printGreetingsWithReversedName()
}
