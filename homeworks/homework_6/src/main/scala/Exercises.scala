object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    var xs: List[T] = List()
    for (x <- seq)
      xs = x :: xs
    xs
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = idx match {
    case 0 | 1 => idx
    case _ => fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
  }

  def fibonacci(idx: Int): Seq[Int] = (0 to idx).map(fibonacci4Index(_))

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(symb => MORSE.getOrElse(symb.toUpper.toString, symb)).mkString(" ").replace(" !", "!")


  def wordReverse(text: String): String = {
    text.split(" ").map(word => {
      val parts = word.partition(_.isLetter)
      if (parts._1.head.isUpper)
        parts._1.reverse.toLowerCase.capitalize + parts._2
      else
        parts._1.reverse + parts._2
    }).mkString(" ")
  }

}
