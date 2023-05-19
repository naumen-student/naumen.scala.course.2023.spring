@main def run() =
  val myName = "Tretyakov Aleksey Vasilevich"
  val reMyName = myName.reverse
  val hMass = Array("Hello", "Hola", "Guten tag", "KU", "privet")
  hMass.foreach(hi => println(f"$hi Scala! This is $myName"))
  println()
  hMass.foreach(hi => println(f"$hi Scala! This is $reMyName"))
