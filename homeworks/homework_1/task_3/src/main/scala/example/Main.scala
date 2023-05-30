package example

object Main extends App{
  val a = ("Hello Scala! This is Andrey Radchuk")
  println(a)
  var helloArray = Array("Hola", "Guten Tag", "Hei")
  val name = "Andrey Radchuk"

  def hello(hello: String, name: String): Unit = {
    println(hello + " Scala! This is " + name)
  }

  for (helloItem <- helloArray)
    hello(helloItem, name)
  for (helloItem <- helloArray)
    hello(helloItem, name.reverse)
}
