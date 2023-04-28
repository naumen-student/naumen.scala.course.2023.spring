object Exercises {

  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  def fibonacci4Index(idx: Int): Int = fibonacci(idx).last
  
  def fibonacci(idx: Int): Seq[Int] = {
    (0 until idx)
      .foldLeft(Seq(0, 1))((s, _) => s :+ s.reverse.take(2).sum)
      .take(idx + 1)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text.map(x => {
      val code = x.toUpper.toString
      val prefix = if (MORSE.contains(code) || x.isWhitespace) " " else ""

      prefix + MORSE.get(code).getOrElse(x)
    })
    .mkString
    .stripPrefix(" ")
  }

  def wordReverse(text: String): String = {
    if (text.length == 0)
      return ""
      
    val word = text.takeWhile(_.isLetter)
    val separator = text.drop(word.length).takeWhile(!_.isLetter)

    if (word.length == 0)
      return separator + wordReverse(text.drop(word.length + separator.length))

    val firstLetter = word.head.toLower
    val lastLetter = if (word.head.isUpper) word.last.toUpper else word.last.toLower
    val reversedWord = lastLetter + word.take(word.length - 1).drop(1).reverse + firstLetter

    reversedWord + separator + wordReverse(text.drop(word.length + separator.length))
  }
}
