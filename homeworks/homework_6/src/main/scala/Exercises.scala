import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.foldRight(Seq[T]())((x, reversed) => reversed :+ x)

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
    val result = new StringBuilder
    text.map(x => MORSE.get(x.toString.toUpperCase) match {
      case Some(m) => result ++= (" " + m)
      case None => if (x == ' ') result ++= "  " else result ++= Seq(x)
    })
    result.toString.trim
  }

  val wordPattern: Regex = "[A-Za-zА-Яа-я]+".r

  def wordReverse(text: String): String = wordPattern.replaceAllIn(text, r => r.toString() match {
    case word if word.head.isUpper => (word.head.toLower + word.tail).reverse.capitalize
    case word => word.reverse
  })

}
