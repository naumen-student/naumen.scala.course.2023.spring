object Main {
  def main(args: Array[String]): Unit = {
    val myName = "Beshkiltsev Ivan".reverse
    val helloVariants = List("Hello", "Hola", "Guten tag")
    helloVariants.foreach(el =>
      println(f"$el Scala! This is $myName")
    )
  }
}