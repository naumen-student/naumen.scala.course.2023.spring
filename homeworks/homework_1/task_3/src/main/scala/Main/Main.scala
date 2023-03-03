object Maim {
  def main(args: Array[String]): Unit = {
    val a = ("Hello Scala! This is Barkan Stepan")

    println(a)

    var helloArray = Array("Hello", "Hola", "Guten tag")

    val name = "Stepan Barkan"

    def hello(hello: String, name: String): Unit = {
      println(hello + " Scala! This is " + name)
    }

    hello("Hello", name)

    hello("Hello", name.reverse)

    for (helloItem <- helloArray)
      hello(helloItem, name)

    for (helloItem <- helloArray)
      hello(helloItem, name.reverse)


  }
}
