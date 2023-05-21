import scala.collection.mutable

object Exercises {

  def reverse[T](seq: Seq[T]): Seq[T] = {
    var res = List[T]()
    for (el <- seq) {
      res = el :: res
    }
    res
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = fibonacci(idx).last

  def fibonacci(idx: Int): Seq[Int] = {
    val res = mutable.MutableList[Int](0, 1)
    var currIndex = 1

    if (idx == 0) {
      return Seq(0)
    }

    while (currIndex < idx) {
      res += res.get(currIndex).get + res.get(currIndex - 1).get
      currIndex += 1
    }

    res
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text.map(c =>
        MORSE.getOrElse(c.toUpper.toString, c)
    ).mkString(" ")
  }


  def wordReverse(text: String): String = {
    text.split(" ").map(word => {
      val part = word.partition(_.isLetter)
      val reversed = part._1.reverse.toLowerCase
      (if (word.headOption.exists(_.isUpper)) reversed.capitalize else reversed) + part._2
    }).mkString(" ")
  }

}
