object Main {
  def main(args: Array[String]): Unit = {
    val greet = (word: String, name: String) => println(s"$word Scala! This is $name!")
    val name = "Sergei"
    val names = Array(name, name.reverse)
    val words = Array("Hello", "Hola", "Guten tag")
    for (name <- names)
      for (word <- words)
        greet(word, name)
  }
}