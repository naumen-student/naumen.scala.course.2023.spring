object Main {
  def main(args: Array[String]): Unit = {
    val name = "Andrei Shvets"
    val name1 = name.reverse
    val ar = Array("Hello", "Hola", "Guten tag")
    val s = "Scala! This is"
    ar.foreach(arg => println(s"$arg $s $name"))
    ar.foreach(arg => println(s"$arg $s $name1"))
  }
}