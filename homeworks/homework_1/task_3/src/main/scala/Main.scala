object Main extends App {
  val name = "NikitaSamkov"
  val getGreetingMessage = (greetingWord: String, userName: String) => f"$greetingWord Scala! This is $userName"
  val grWords = Array("Hello", "Hola", "Guten tag")
  val printGreetings = (words: Array[String], name: String) => words.foreach(word => println(getGreetingMessage(word, name)))
  printGreetings(grWords, name)
  printGreetings(grWords, name.reverse)
}
