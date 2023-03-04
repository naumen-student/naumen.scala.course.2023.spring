import utest._
import Exercises._

object Test extends TestSuite {

  val tests = Tests {
    'test_divBy3Or7 - {
      assert(divBy3Or7(1, 3) == Seq(3))
      assert(divBy3Or7(5, 9) == Seq(6, 7, 9))
      assert(divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
    }

    'test_sumOfDivBy3Or5 - {
      assert(sumOfDivBy3Or5(1, 10000000) > 0)
      assert(sumOfDivBy3Or5(1, 1) == 0)
      assert(sumOfDivBy3Or5(1, 3) == 3)
      assert(sumOfDivBy3Or5(-100, 100) == 0)
      assert(sumOfDivBy3Or5(10, 22) == 96)
    }

    'test_primeFactor - {
      assert(primeFactor(80) == Seq(2, 5))
      assert(primeFactor(98) == Seq(2, 7))
      assert(primeFactor(0) == Seq())
      assert(primeFactor(90909090) == Seq(2, 3, 5, 73, 101, 137))
    }

    val (v1, v2, v3, v4) = (Vector2D(1.9, 5.6), Vector2D(8.9999, -5), Vector2D(5.7, 0), Vector2D(1.9, 5.6))
    'test_sumScalars - {
      assert(sumScalars(v1, v2, v3, v4) == scalar(v1, v2) + scalar(v3, v4))
    }
    'test_sumCosines - {
      assert(sumCosines(v1, v2, v3, v4) == cosBetween(v1, v2) + cosBetween(v3, v4))
    }

    val testBalls1 = Map(
      "Aluminum" -> (3, 2.6889), "Nickel" -> (2, 8.91), "Tin" -> (1, 7.29), "Platinum" -> (1, 21.45),
      "Titanium" -> (2, 10.50)
    )
    val testBalls2 = Map(
      "Titanium" -> (2, 10.50)
    )
    val testBalls3: Map[String, (Int, Double)] = Map()
    'test_sortByHeavyWeight - {
      assert(sortByHeavyweight(testBalls1) == Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium"))
      assert(sortByHeavyweight(testBalls2) == Seq("Titanium"))
      assert(sortByHeavyweight(testBalls3) == Seq())
    }
  }
}
