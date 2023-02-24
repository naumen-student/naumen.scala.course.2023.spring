object Main {
  def main(args: Array[String]): Unit = {
    var name = "Matthew"

    def hello(greeting: String, name: String) : Unit = {
      println(s"$greeting Scala! This is $name")
    }

    hello("Hello", name)

    var greetings = Array("Guten tag", "Privet", "Ni hao")

    greetings.foreach(greeting => hello(greeting, name))

    greetings.foreach(greeting => hello(greeting, name.reverse))
  }
}