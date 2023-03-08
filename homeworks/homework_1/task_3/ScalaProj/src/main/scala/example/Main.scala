package example

object Main {
  def main(args: Array[String]): Unit = {
    val greetings = Array("Hello", "Hola", "Guten tag")

    val name = "Pavel"

    val surname = "Petrovskiy"


    def hello(greeting: String, name: String, surname: String): Unit = {
      println(greeting + " Scala! This is " + name + " " + surname)
    }

tas
    for (greeting <- greetings)
      hello(greeting, name, surname)


    for (greeting <- greetings)
      hello(greeting, name.reverse, surname.reverse)
  }
}
