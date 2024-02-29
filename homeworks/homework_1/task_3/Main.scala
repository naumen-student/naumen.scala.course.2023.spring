object Main {
  def main(args: Array[String]): Unit = {
    var repl: ReplServiceImpl = new ReplServiceImpl("Hello", "Balaba Sofya")
    repl.print()
    repl.name = "Balaba Sofya".reverse
    repl.helloWord = "Hola"
    repl.print()
  }
}