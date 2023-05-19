object Exercises {
  import scala.annotation.tailrec
  import scala.collection.mutable


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

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
    text.split(" ").map(
      w => {
        val pos = w.partition(_.isLetter)
        val reverse = pos._1.reverse.toLowerCase
        if (w.headOption.exists(_.isUpper)) reverse.capitalize + pos._2
        else reverse + pos._2
      }).mkString(" ")
  }

}
