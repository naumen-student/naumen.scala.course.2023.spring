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

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  private val CODE = 0
  private val NONCODE = 1

  def morse(text: String): String = text
    .toUpperCase()
    .map(symbol => {
      val code = MORSE.get(symbol.toString)
      if (code.isEmpty)
        (symbol, if (symbol != ' ') NONCODE else CODE)
      else
      (code.get, CODE)
    })
    .foldLeft(("", NONCODE))((left, right) => if (left._2 == CODE && right._2 == CODE) (left._1 + " " + right. _1, CODE) else (left._1 + right._1, right._2))
    ._1

  def getNextBlock(str: String): (String, String) = {
    if (str.isEmpty)
      return ("", "")
    val takeRule = if (str(0).isLetter) (c: Char) => c.isLetter else (c: Char) => !c.isLetter
    val block = str.takeWhile(takeRule)
    val remaining = str.drop(block.length)
    (block, remaining)
  }

  def wordReverse(text: String): String = {
    val (block, remaining) = getNextBlock(text)
    if (block.isEmpty)
      return ""
    (if (block(0).isLetter) if (block(0).isUpper) (block(0).toLower + block.drop(1)).reverse.capitalize else block.reverse else block) + wordReverse(remaining)
  }

}
