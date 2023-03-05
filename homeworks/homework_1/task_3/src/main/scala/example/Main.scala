package example

object Main extends App {
  val name = "Mikhail Lanskikh"
  val e = "Hello Scala! This is " + name
  println(e)
  val s = e.replace("Hello", "Hola")
  println(s)
  val g = e.replace("Hello", "Guten tag")
  println(g)

  def reverseName(str: String, name: String): String = str.replace(name, name.reverse)

  val eReversed = reverseName(e, name)
  println(eReversed)
  val sReversed = reverseName(s, name)
  println(sReversed)
  val gReversed = reverseName(g, name)
  println(gReversed)
}
