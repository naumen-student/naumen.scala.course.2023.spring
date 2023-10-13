object Main {
  def main(args: Array[String]): Unit = {
    var name = "Artyom"
    var greetings = Array(
      "Hello",
      "Bonjour",
      "As-salamu alaykum",
    )

    var reversedName = new StringBuffer(name).reverse().toString()

    def printGreeting(greeting: String, name: String) = println(s"$greeting Scala! This is $name")

    def printGreetingsForName(greetings: Array[String], name: String) = for (greet <- greetings) printGreeting(greet, name)

    printGreetingsForName(greetings, name)
    printGreetingsForName(greetings, reversedName)
  }
}