object Main {
  def main(args: Array[String]): Unit = {
    val helloArray = Array("Hello", "Hola", "Guten tag")

    val name = "Grishin Simeon"


    def hello(hello: String, name: String): Unit = {
      println(hello + " Scala! This is " + name)
    }


    for (helloItem <- helloArray)
      hello(helloItem, name)


    for (helloItem <- helloArray)
      hello(helloItem, name.reverse)

  }
}