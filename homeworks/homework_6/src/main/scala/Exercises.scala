import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = if (seq.length == 1) seq else reverse(seq.drop(1)) :+ seq.head

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    if (idx < 1) throw new ArithmeticException()

    var numbers = Seq(0, 1, 1)
    for (i <- 3 to idx) {
      numbers :+= numbers(i - 1) + numbers(i - 2)
    }

    numbers(idx)
  }

  def fibonacci(idx: Int): Seq[Int] = {
    if (idx < 1) throw new ArithmeticException()

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

  def morse(text: String): String = text.map(c => MORSE.get(c.toUpper.toString) match {
    case Some(s) => ' ' + s
    case None => if (c == ' ') "  " else c.toString
  })
    .mkString
    .trim

  def wordReverse(text: String): String =
    splitToWordsAndPunctuation(text)
      .map(s => if (isWord(s) && s.head.isUpper) s.reverse.toLowerCase.capitalize
      else if (isWord(s) && s.head.isLower) s.reverse
      else s)
      .mkString

  private def splitToWordsAndPunctuation(text: String): Array[String] =
    new Regex("([\\wЁёА-я]+|[^\\wЁёА-я]+)")
      .findAllIn(text)
      .toArray

  private def isWord(text: String): Boolean = text.forall(c => c.isLetter)
}
