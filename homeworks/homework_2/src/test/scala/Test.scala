import Exercises._
import utest._

object Test extends TestSuite {
  val tests: Tests = Tests {
    'test_divBy3Or7 - {
      assert(divBy3Or7(1, 3) == Seq(3))
      assert(divBy3Or7(5, 9) == Seq(6, 7, 9))
      assert(divBy3Or7(0, 100) == Seq(
        0, 3, 6, 7, 9,
        12, 14, 15, 18, 21,
        24, 27, 28, 30, 33,
        35, 36, 39, 42, 45,
        48, 49, 51, 54, 56,
        57, 60, 63, 66, 69,
        70, 72, 75, 77, 78,
        81, 84, 87, 90, 91,
        93, 96, 98, 99))
    }
    'test_sumOfDivBy3Or5 - {
      assert(sumOfDivBy3Or5(0, 0) == 0)
      assert(sumOfDivBy3Or5(0, 3) == Seq(3).sum)
      assert(sumOfDivBy3Or5(0, 5) == Seq(3, 5).sum)
      assert(sumOfDivBy3Or5(0, 7) == Seq(3, 5, 6).sum)
      assert(sumOfDivBy3Or5(0, 100) == 2418)
    }
    'test_primeFactor - {
      assert(primeFactor(0) == Seq())
      assert(primeFactor(1) == Seq())
      assert(primeFactor(2) == Seq(2))
      assert(primeFactor(5) == Seq(5))
      assert(primeFactor(80) == Seq(2, 2, 2, 2, 5).distinct)
      assert(primeFactor(98) == Seq(2, 7, 7).distinct)
    }
    'test_sumScalars - {
      assert(sumScalars(Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0)) == 0)
      assert(sumScalars(Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0), Vector2D(0, 1)) == 0)
      assert(sumScalars(Vector2D(1, 1), Vector2D(0, 1), Vector2D(0, 0), Vector2D(0, 0)) == 1)
      assert(sumScalars(Vector2D(1, 1), Vector2D(0, 1), Vector2D(1, 1), Vector2D(0, 1)) == 2)
      assert(sumScalars(Vector2D(2, 1), Vector2D(1, 1), Vector2D(0, 0), Vector2D(0, 0)) == 3)
    }
    'test_sumCosines - {
      assert(sumCosines(Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0)).isNaN)
      assert(sumCosines(Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0), Vector2D(0, 1)) == 0)
      assert(sumCosines(Vector2D(1, 0), Vector2D(1, 0), Vector2D(1, 0), Vector2D(0, 1)) == 1)
      assert(sumCosines(Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0), Vector2D(1, 0)) == 1)
      assertDoubles(
        sumCosines(Vector2D(1, 0), Vector2D(1, 1), Vector2D(1, 0), Vector2D(0, 1)),
        math.sqrt(2) / 2
      )
      assertDoubles(
        sumCosines(Vector2D(1, 0), Vector2D(1, 1), Vector2D(1, 0), Vector2D(1, 0)),
        1 + math.sqrt(2) / 2
      )
    }
  }

  private def assertDoubles(n1: Double, n2: Double): Unit = {
    assert(math.abs(n1 - n2) <= 1e-7)
  }
}
