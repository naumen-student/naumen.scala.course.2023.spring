object Exercises {

  def main(args: Array[String]): Unit = {
    println(fibonacci(1))
    println(morse("Friendly"))
    println(wordReverse("Друзья, давайте жить дружно!"))
  }

  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = fibonacci(idx).last

  def fibonacci(idx: Int): Seq[Int] = {
    require(idx >= 0, "The index must be positive!")

    val fibs = (0 to idx).foldLeft(Seq(0, 1)) {
      case (seq, i) if i <= 1 => seq
      case (seq, i) => seq :+ (seq(i - 1) + seq(i - 2))
    }

    fibs.take(idx + 1)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String =
    text.map(symbol => {
      MORSE.get(symbol.toUpper.toString)
        .map(code => s" $code")
        .getOrElse(if (symbol == '!') symbol.toString else s" $symbol")
    }).mkString("").trim


  def wordReverse(text: String): String = {
    text.split(" ").map(
      w => {
        val p = w.partition(_.isLetter)
        val rev = p._1.reverse.toLowerCase
        if (w.headOption.exists(_.isUpper)) rev.capitalize + p._2
        else rev + p._2
      }).mkString(" ")
  }
}