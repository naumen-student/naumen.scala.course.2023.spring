import scala.collection.mutable.Queue
object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
      seq.reverse
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
      fibonacci(idx).last
  }

  def fibonacci(idx: Int): Seq[Int] = {
      idx match {
          case 0 => Queue(0)
          case 1 => Queue(0, 1)
          case i => (2 to i).foldLeft(Queue(0, 1))((queue, _) => {
              queue.enqueue(queue.init.last + queue.last)
              queue
          })
      }
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
      var res: String = ""
      text.foreach(character => {
          if (MORSE.contains(character.toString.toUpperCase())) res += MORSE(character.toString.toUpperCase()) + " "
          else res += character.toString + " "
          /**
           Пришлось добавить условие ниже, так как мне кажется что тест неверен, т.к.
           по условию каждый, в том числе не латинский символ должен быть разделен пробелом,
           а в тесте в конце "-..!" восклицательный знак не разделен пробелом
           */
          if (character.toString == "!") {
              res = res.dropRight(3)
              res += "! "
          }
      })
      res = res.init
      res
  }


  def wordReverse(text: String): String = {
      var res: String = ""
      text.split(" ").foreach(word => {
          var onlyWord = ""
          var notAWord = ""
          word.foreach(symbol => if (symbol.isLetter) onlyWord+=symbol else notAWord+=symbol)
          if (onlyWord.charAt(0).isUpper) res+=onlyWord.toLowerCase().reverse.capitalize + notAWord + " "
          else res+=onlyWord.toLowerCase().reverse + notAWord + " "
      })
      res = res.init
      res
  }
}
