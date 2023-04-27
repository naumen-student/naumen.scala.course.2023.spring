object Exercises {
  import scala.annotation.tailrec
  import scala.collection.mutable


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci(idx: Int): Seq[Int] = {
    if (idx == 0)
      return Seq(0)
    if (idx == 1)
      return Seq(0, 1)
    val numbers = Array.fill(idx + 1)(0)
    numbers(1) = 1
    for (i <- 2 to idx)
      numbers(i) = numbers(i - 1) + numbers(i - 2)
    numbers
  }
  def fibonacci4Index(idx: Int): Int = fibonacci(idx).last

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    val builder = new StringBuilder
    val keys = MORSE.keys.toList
    text.foreach { x =>
      val s = x.toTitleCase.toString
      builder.append(if (keys.contains(s)) " " + MORSE(s) else if (s == "!") s else " " + s)
    }
    builder.toString().stripPrefix(" ")
  }


  def wordReverse(text: String): String = {
    val builder = new StringBuilder()
    var isWord = false
    var upper = false
    val word = new StringBuilder()
    text.foreach { x =>
      if (x.isLetter) {
        isWord = true
        if (!upper) upper = x.isUpper
        word.insert(0, x.toLower)
      }
      else {
        if (upper) word.replace(start = 0, end = 1, str = word.head.toTitleCase.toString)
        builder.append(word).append(x)
        isWord = false
        upper = false
        word.clear()
      }
    }
    builder.toString()
  }

}
