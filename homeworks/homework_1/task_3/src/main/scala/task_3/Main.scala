package task_3

object Main extends App{
	val printHiScala = (hello: String, name: String) => println(f"$hello Scala! This is $name")

	val name = "Ilya Kozik"

	val helloWords = Array("Hello", "Hola", "Guten tag")

	val nameVarieties = Array(name, name.reverse)

	nameVarieties.foreach(name => {
		println("---")
		helloWords.foreach(hello => printHiScala(hello, name))
	})
}
