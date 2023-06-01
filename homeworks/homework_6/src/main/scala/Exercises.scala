object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse
  
  def fibonacci4Index(idx: Int): Int = {
    require(idx >= 0, "Индекс должен быть не меньше нуля")
    if (Seq(1, 2).contains(idx)) return 1
    fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
  }

  def fibonacci(idx: Int): Seq[Int] = {
    require(idx >= 0, "Индекс должен быть не меньше нуля")
    if (idx == 1) Seq(0)
    if (idx == 2) Seq(0, 1)
    val fib = Array.fill(idx + 1)(0)
    fib(1) = 1
    for (i <- 2 to idx) fib(i) = fib(i - 1) + fib(i - 2)
    fib
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text
    .map(char => {
      val code = MORSE.get(char.toUpper.toString)
      if (code.isEmpty) if (char == '!') char else " " + char else " " + code.get
    }).mkString("").trim


  def wordReverse(text: String): String = text
    .split(" ")
    .map(word => {
      val (letters, notLetters) = word.partition(_.isLetter)
      val reversed = letters.reverse.toLowerCase
      (if (word(0).isUpper) reversed.capitalize else reversed) + notLetters
    }).mkString(" ")

}
