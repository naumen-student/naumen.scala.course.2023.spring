object Main {
  def main(args: Array[String]): Unit = {
    val name = "Anush"
    println("Hello Scala! This is " + name)
    def printGreeting(greeting: String, name: String): Unit = println(greeting + " Scala! This is " + name)
    printGreeting("Hola", name)
    printGreeting("Guten tag", name)
    printGreeting("Hi", name.reverse)
  }
}