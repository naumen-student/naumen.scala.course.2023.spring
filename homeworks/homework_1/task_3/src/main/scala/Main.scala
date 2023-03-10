@main def hello: Unit = 
  var name = "Kirill"
  var greetings = Array(
    "Hello",
    "Hallo",
    "Guten tag"
  )

  var reversedName = new StringBuffer(name).reverse().toString()

  def printGreeting(greeting: String, name: String) = println(s"$greeting Scala! This is $name")
  def printGreetingsForName(greetings: Array[String], name: String) = for (greet <- greetings) printGreeting(greet, name)

  printGreetingsForName(greetings, name)
  printGreetingsForName(greetings, reversedName)
