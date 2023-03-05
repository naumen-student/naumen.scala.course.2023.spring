object Main {
  def main(args: Array[String]): Unit = {
    val myName = "Korshunov Alexander".reverse
    val hiList = List("Hello", "Hola", "Guten tag")
    hiList.foreach(el =>
      println(f"$el Scala! This is $myName")
    )
  }
}