import scala.annotation.tailrec
import scala.collection.mutable

object Exercises {

  def reverse[T](seq: Seq[T]): Seq[T] = (seq.size - 1 to 0).map(x =>  seq(x))

  def fibonacci4Index(idx: Int): Int = {
    var num = 0

    @tailrec
    def fib(n1: Int, n2: Int): Int = {
      if (num == idx - 1) return n2
      num += 1
      fib(n2, n2 + n1)
    }

    fib(0, 1)
  }

  def fibonacci(idx: Int): Seq[Int] = {
    val list = Seq(0, 1).to[mutable.MutableList]
    while (list.size < idx + 1) {
      list += list(list.size - 2) + list.last
    }
    list
  }

  private lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
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
