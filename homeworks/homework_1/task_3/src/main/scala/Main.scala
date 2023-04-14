object Main extends App {
  val greets = Array("Hello", "Hola", "Guten tag")
  val names = Array("Alexander", "Alexander".reverse)

  def greet(hello: String, name: String): Unit = {
    println(hello + " Scala! This is " + name)
  }

  names.foreach(n => greets.foreach(g => greet(g, n)))
}
