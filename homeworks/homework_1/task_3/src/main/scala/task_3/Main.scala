package task_3

object Main {
  def main(args: Array[String]): Unit = {
    var name="Irina"
    println(s"Hello Scala! This is $name")
    var greetings=Array("Hallo","Konichiwa","Oh, hi",1101000)

    greetings.foreach(greeting => println(s"$greeting Scala! This is $name"))
    println()
    greetings.foreach(greeting => println(s"$greeting Scala! This is ${name.reverse}"))
  }

}
