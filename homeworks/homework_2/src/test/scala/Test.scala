import utest._
import Exercises.Vector2D

object Test extends TestSuite {
  val tests = Tests {
    'test_divBy3Or7 - {
      assert(Exercises.divBy3Or7(1, 3) == Seq(3))
      assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
      assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
    }
    'test_sumOfDivBy3Or5 - {
      assert(Exercises.sumOfDivBy3Or5(1, 10) == 23L)
      assert(Exercises.sumOfDivBy3Or5(5, 15) == 57L)
      assert(Exercises.sumOfDivBy3Or5(20, 35) == 195L)
      assert(Exercises.sumOfDivBy3Or5(0, 0) == 0L)
      assert(Exercises.sumOfDivBy3Or5(5, 5) == 5L)
      assert(Exercises.sumOfDivBy3Or5(0, 1) == 0L)
    }
    'test_primeFactor - {
      assert(Exercises.primeFactor(1) == Seq())
      assert(Exercises.primeFactor(80) == Seq(2, 5))
      assert(Exercises.primeFactor(98) == Seq(2, 7))
      assert(Exercises.primeFactor(900) == Seq(2, 3, 5))
      assert(Exercises.primeFactor(121) == Seq(11))
      assert(Exercises.primeFactor(122) == Seq(2, 61))
    }
    'sumByFunc - {
      assert(Exercises.sumScalars(Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0)) == 0)
      assert(Exercises.sumScalars(Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1)) == 4)
      assert(Math.abs(Exercises.sumCosines(Vector2D(3, 21), Vector2D(4, 13), Vector2D(2, 3), Vector2D(7, 4)) - 1.882) < 0.001)
    }
    'sortByHeavyweight - {
      assert(Exercises.sortByHeavyweight(Map()) == Seq())
      assert(Exercises.sortByHeavyweight(Map(
        "Heavy" -> (12, 12),
        "Light" -> (2, 2),
        "Medium" -> (11, 1))
      ) == Seq("Light", "Medium", "Heavy"))
      assert(Exercises.sortByHeavyweight(Map(
        "Light" -> (4, 4),
        "Medium" -> (121, 121),
        "Heave" -> (897, 952))
      ) == Seq("VeryLight", "Light", "NotLight"))
    }
  }
}
