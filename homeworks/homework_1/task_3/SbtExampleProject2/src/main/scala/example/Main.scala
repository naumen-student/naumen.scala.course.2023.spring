object Main extends App {
  def printGreeting (name : String, greet : String) = (println(f"$greet Scala! This is $name"))

  val name: String = "Nikita"
  printGreeting(name, "Hello")
  val greetings = Array("Guten tag", "Hola", "Hi")
  greetings.foreach(greet => printGreeting(name, greet))
  greetings.foreach(greet => printGreeting(name.reverse, greet))
}

