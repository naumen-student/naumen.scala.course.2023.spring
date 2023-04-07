object Main {

  val name = "Alhassan Alfarran"
  private val greeting = "Hello"
  private val greetingMessage: String = s"$greeting Scala! This is $name"
  private val greetingVariations = Seq("Hola", "Guten tag")
  private val greetingMessages = greetingVariations.map(g => s"$g Scala! This is $name")
  private val reversedName = name.reverse
  private val reversedNameVariations = Seq(name, reversedName)
  private val reversedNameMessages = reversedNameVariations.flatMap(n => greetingVariations.map(g => s"$g Scala! This is $n"))

  def main(args: Array[String]): Unit = {
    println(greetingMessage)
    println(greetingMessages)
    println(reversedNameMessages)
  }
}
