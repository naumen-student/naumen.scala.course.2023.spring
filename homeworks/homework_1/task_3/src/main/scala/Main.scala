object Main extends App {
  val name = "Yura Perov"
  val greetings = Array("Hello", "Hola", "Guten tag")

  val printGreeting = (greeting: String, name: String) =>
    println(f"$greeting Scala! This is $name")

  val printGreetings = (greetings: Array[String], name: String) =>
    greetings.foreach(greeting => printGreeting(greeting, name))

  printGreeting("Hello", name)
  printGreetings(greetings, name)
  printGreetings(greetings, name.reverse)
}