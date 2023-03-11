import utest._
import Exercises._

object Test extends TestSuite{
    val tests: Tests = Tests{
        'test_divBy3Or7 - {
            assert(divBy3Or7(1, 3) == Seq(3))
            assert(divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(sumOfDivBy3Or5(0, 0) == 0)
            assert(sumOfDivBy3Or5(0, 3) == 3)
            assert(sumOfDivBy3Or5(3, 3) == 3)
            assert(sumOfDivBy3Or5(3, 5) == 3 + 5)
            assert(sumOfDivBy3Or5(0, 15) == 3 + 6 + 9 + 12 + 15 + 5 + 10)
        }
        'test_primeFactor - {
            assert(primeFactor(0) == Seq())
            assert(primeFactor(1) == Seq())
            assert(primeFactor(-100) == Seq())
            assert(primeFactor(3) == Seq(3))
            assert(primeFactor(100) == Seq(2, 5))
        }
    }
}
