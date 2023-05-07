object Exercises {

    def main(args: Array[String]): Unit = {
        println(wordReverse("Зима!.. Крестьянин, торжествуя..."))
    }


    def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

    /**
     * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
     *
     * @param idx
     * @return
     */
    def fibonacci4Index(idx: Int): Int = {
        require(idx >= 0, "Индекс должен быть положительным!")
        if (idx == 1) return 0
        if (idx == 2) return 1
        val fib = Array(0, 1)
        for (i <- 2 to idx) {
            fib(i % 2) = fib(0) + fib(1)
        }
        fib(idx % 2)
    }


    def fibonacci(idx: Int): Seq[Int] = {
        require(idx >= 0, "Индекс должен быть положительным!")
        if (idx == 1) return Seq(0)
        if (idx == 2) return Seq(0, 1, 1)
        val fib = Array.fill(idx + 1)(0)
        fib(1) = 1
        for (i <- 2 to idx) {
            fib(i) = fib(i - 1) + fib(i - 2)
        }
        fib
    }


    lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
        "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
        "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
        "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
        "Y" -> "-.--", "Z" -> "--..")

    def morse(text: String): String = {
        text.map(ch => {
            val code = MORSE.get(ch.toUpper.toString)
            if (code.isEmpty) if (ch == '!') ch else " " + ch else " " + code.get
        }).mkString("").trim
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
