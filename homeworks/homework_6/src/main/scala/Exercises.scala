import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    idx match{
      case 0 => 0
      case 1 => 1
      case i => fibonacci4Index(i-1) + fibonacci4Index(i-2)
    }
  }

  def fibonacci(idx: Int): Seq[Int] = {
    idx match {
      case 0 => Seq(0)
      case i => fibonacci(i-1) :+ fibonacci4Index(i)
    }
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String =
    text.map(chr => MORSE.get(chr.toUpper.toString)
                          .map(str => s" $str")
                          .getOrElse(if(chr == ' ') "  " else chr.toString))
      .mkString("").trim


  def wordReverse(text: String): String =
    new Regex("\\p{L}+").replaceAllIn(text, word => {
      val reversed = word.toString().reverse
      if (reversed.last.isUpper) reversed.toLowerCase().capitalize else reversed
    })

}
