val name = "Alhassan Alfarran"
val greeting = "Hello"
val greetingMessage = s"$greeting Scala! This is $name"
val greetingVariations = Seq("Hola", "Guten tag")
val greetingMessages = greetingVariations.map(g => s"$g Scala! This is $name")
val reversedName = name.reverse
val reversedNameVariations = Seq(name, reversedName)
val reversedNameMessages = reversedNameVariations.flatMap(n => greetingVariations.map(g => s"$g Scala! This is $n"))
scala.tools.nsc.io.File("console-output.txt").writeAll((greetingMessage +: greetingMessages ++: reversedNameMessages).mkString("\n"))
val name = "Alhassan Alfarran"
def reverseString(str: String): String = {
  str.reverse
}
val greetings = List("Hello", "Hola", "Guten tag")
for (greeting <- greetings) {
  val reversedName = reverseString(name)
  val message = s"$greeting Scala! This is $reversedName"
  println(message)
}
scala.tools.nsc.io.File("console-output.txt").writeAll((greetingMessage +: greetingMessages ++: reversedNameMessages).mkString("\n"))
