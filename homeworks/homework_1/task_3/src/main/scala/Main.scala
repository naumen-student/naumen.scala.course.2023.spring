object Main extends App {
  val name = "Artak"
  val greetMe: (String) => String = _ + s" ${name}"
  val greetMeReversed: (String) => String = _ + s" ${name.reverse}"
  val greetings = List("Hello", "Hola", "Guten tag", "Barev")
  println(greetings.map(greetMe(_)).mkString("\n"))
  println(greetings.map(greetMeReversed(_)).mkString("\n"))
}