package example

class GreetingPrinter{
  def printGreeting(greeting: String, name: String): Unit = {
    println(s"$greeting Scala! This is $name")
  }

  def printGreetings(greetings: Array[String], name: String): Unit = {
    for (greet <- greetings) {
      printGreeting(greet, name)
    }
  }

  def reverseName(name: String): String = {
    new StringBuffer(name).reverse().toString
  }
}
