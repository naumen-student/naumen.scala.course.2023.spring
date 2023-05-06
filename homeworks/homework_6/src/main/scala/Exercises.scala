import scala.util.matching.Regex

object Exercises {


  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = idx match {
    case 0 => 0
    case 1 => 1
    case i => fibonacci4Index(i - 1) + fibonacci4Index(i - 2)
  }

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 0 => Seq(0)
    case 1 => Seq(0, 1)
    case i => fibonacci(i - 1) :+ fibonacci4Index(i)
  }

  def morse(text: String): String = text.map(char => MORSE.get(char.toString.toUpperCase) match {
    case Some(s) => ' ' + s
    case None => if (char == ' ') "  " else char.toString
  }).mkString("").trim


  def wordReverse(text: String): String = {
    new Regex("\\pL+").replaceAllIn(text, w => {
      val reversed = w.toString().reverse
      if (reversed.last.isUpper)
        reversed.toLowerCase.capitalize
      else
        reversed
    })
  }
}