import Exercises.sortByHeavyweight

object Main {
  def main(args: Array[String]): Unit = {
    println(sortByHeavyweight(Map("a" -> (1, 1), "b" -> (1, 2))))
    println(sortByHeavyweight(Map("a" -> (1, 1), "b" -> (2, 1))))
    println(sortByHeavyweight(Map("b" -> (1, 2), "a" -> (1, 1))))
    println(sortByHeavyweight(Map("a" -> (1, 1), "b" -> (1, 5), "c" -> (10, 1))))
  }
}