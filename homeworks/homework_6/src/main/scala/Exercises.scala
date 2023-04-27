object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = fibonacci(idx).last

  def fibonacci(idx: Int): Seq[Int] = {
    if (idx == 0)
      return Seq(0)
    if (idx == 1)
      return Seq(0, 1)
    val fib: Array[Int] = Array.fill(idx + 1)(0)
    fib(1) = 1
    for (i <- 2 to idx)
      fib(i) = fib(i - 1) + fib(i - 2)
    fib
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    val builder: StringBuilder = new StringBuilder
    val keys = MORSE.keys.toList
    text.foreach { x =>
      val s = x.toTitleCase.toString
      builder.append(
        if (keys.contains(s)) " " + MORSE(s) else if (s == "!") s else " " + s
      )
    }
    builder.toString().stripPrefix(" ")
  }


  def wordReverse(text: String): String = {
    text
      .split(" ")
      .map(word => {
        val parts : (String, String) = word.partition(_.isLetter)
        val reversed : String = parts._1.toLowerCase.reverse
        (if (word.headOption.exists(_.isUpper)) reversed.capitalize
        else reversed) + parts._2
      })
      .mkString(" ")
  }
}
