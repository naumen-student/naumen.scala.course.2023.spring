
object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    var result: List[T] = Nil
    for (s <- seq) result = s +: result
    result
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = fibonacci(idx).last

  def fibonacci(idx: Int): Seq[Int] = {
    var numbers = Seq(0, 1, 1)
    for (i <- 3 to idx) {
      numbers :+= numbers(i - 1) + numbers(i - 2)
    }
    numbers
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(char => MORSE.get(char.toString.toUpperCase) match {
    case Some(s) => ' ' + s
    case None => if (char == ' ') "  " else char.toString
  }).mkString("").trim


  def wordReverse(text: String): String =
    "[A-Za-zА-Яа-я]+".r.replaceAllIn(text, r => {
      var word = r.toString()
      if (word(0).isUpper) word.reverse.toLowerCase.capitalize else word.reverse
      })

}
