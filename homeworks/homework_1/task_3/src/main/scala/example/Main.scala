package example

object Main extends App {
  private val printer = new GreetingPrinter()
  private val name = "Andrey Morozov"
  private val greetings: Array[String] = Array(
    "Hello",
    "Hi",
    "Shalom"
  )

  printer.printGreetings(greetings, name)
  printer.printGreetings(greetings, printer.reverseName(name))
}
