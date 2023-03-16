object Main {
  def main(args: Array[String]): Unit = {
    multipleHello("Ilya")
  }

  val greetings: Array[String] = Array("Bonjour",
    "Hello",
    "Buenos días",
    "Guten Tag",
    "Buongiorno",
    "Olá",
    "Dzień dobry",
    "Shalom",
    "Merhaba",
    "God dag",
    "Dobrý den",
    "Hyvää päivää",
    "Szervusz")

  def multipleHello(name: String): Unit = {
    for (greeting <- greetings)
      println(s"$greeting Scala! This is $name")
  }

  multipleHello("Ilya")
}