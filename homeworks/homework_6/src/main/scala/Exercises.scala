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
    idx match {
      case 0 => Seq(0)
      case 1 => Seq(0, 1)
      case i => (2 to i).foldLeft(Seq(0, 1))((s, _) => s :+ (s.init.last + s.last))
    }
  }

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
    text.split(" ").map(word => {
      val part = word.partition(_.isLetter)
      val reversed = part._1.reverse.toLowerCase
      (if (word.headOption.exists(_.isUpper)) reversed.capitalize
      else reversed) + part._2

    }).mkString(" ")
  }

}
