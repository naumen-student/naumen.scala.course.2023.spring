object Task3 extends App {
  val name: String = "Doguhan Kaan"
  val helloString: String = s"Hello Scala! This is $name"
  println(helloString)

  val helloWords: Array[String] = Array("Hello", "Hola", "Guten tag")

  for (helloWord <- helloWords)
    println(s"$helloWord Scala! This is $name")

  for (helloWord <- helloWords)
    println(s"$helloWord Scala! This is ${name.reverse}")
}
