object Main {
  def main(args: Array[String]): Unit = {
    val name = "Ivan Tyagunov"
    val x: Seq[String] = Seq("Hello", "Hola", "Guten tag")
    val greeting_phrase = " Scala! This is "

    def print_intim_hello(name: String) = {
      for (elem <- x) println(s"$elem" + greeting_phrase + s"$name")
    }

    print_intim_hello(name)

    print_intim_hello(name.reverse)
  }
}