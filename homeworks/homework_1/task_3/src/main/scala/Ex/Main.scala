package Ex

object Main {

  def main(args: Array[String]): Unit = {
    var name = "Viva de Vova"
    var hiNamesOptions=Array("Hello","hi", 1)

    println(f"Hi, This is ${name.reverse}")



    for(name1 <- hiNamesOptions) println(f"${name1}! This is ${name.reverse}")
  }
}