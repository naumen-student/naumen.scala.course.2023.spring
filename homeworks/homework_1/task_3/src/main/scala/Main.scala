object Main {
  def main(args: Array[String]): Unit = {
    val show = (greeting: String, name: String) =>
      greeting + " Scala! This is " + name

    val name = "James Dylan"

    println(show("Hello", name))
    println(show("Hola", name))
    println(show("Salut", name))

    println(show("Hello", name.reverse))
    println(show("Hola", name.reverse))
    println(show("Salut", name.reverse))
  }
}