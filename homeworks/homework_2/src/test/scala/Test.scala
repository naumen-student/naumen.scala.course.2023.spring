import Exercises.Vector2D
import utest._

object Test extends TestSuite {

    val tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(1, 10) == 33)
            assert(Exercises.sumOfDivBy3Or5(1, 100) == 2418)
            assert(Exercises.sumOfDivBy3Or5(1, 1000) == 234168)
            assert(Exercises.sumOfDivBy3Or5(100, 500) == 56100)
            assert(Exercises.sumOfDivBy3Or5(123, 200) == 5948)
            assert(Exercises.sumOfDivBy3Or5(50, 150) == 4782)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(123) == Seq(3, 41))
            assert(Exercises.primeFactor(1001) == Seq(7, 11, 13))
            assert(Exercises.primeFactor(4789523) == Seq(139, 34457))
            assert(Exercises.primeFactor(999999) == Seq(3, 7, 11, 13, 37))
        }

        'test_sumScalars - {
            assert(Exercises.sumScalars(Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0)) == 0)
            assert(Exercises.sumScalars(Vector2D(1, 0), Vector2D(0, 1), Vector2D(0, -1), Vector2D(-1, 0)) == 0)
            assert(Exercises.sumScalars(Vector2D(1, 0), Vector2D(1, 0), Vector2D(0, -1), Vector2D(0, -1)) == 2)
            assert(Exercises.sumScalars(Vector2D(12, 4), Vector2D(-7, 4), Vector2D(-9, 3), Vector2D(-7, 1)) == -2)

        }

        'test_sumCosines - {
            assert(Exercises.sumCosines(Vector2D(1, 0), Vector2D(0, 1), Vector2D(-1, 0), Vector2D(1, 0)) == -1)
            assert(Exercises.sumCosines(Vector2D(1, 0), Vector2D(0, -1), Vector2D(1, 0), Vector2D(0, 1)) == 0)
            assert(Exercises.sumCosines(Vector2D(Math.sqrt(2) / 2, Math.sqrt(2) / 2), Vector2D(Math.sqrt(2) / 2, Math.sqrt(2) / 2), Vector2D(1, 0), Vector2D(-1, 0)) <= 0.0000001)
            assert(Exercises.sumCosines(Vector2D(1, 0), Vector2D(Math.sqrt(3) / 2, 0.5), Vector2D(1, 0), Vector2D(Math.sqrt(3) / 2, 0.5)) - Math.sqrt(3) <= 0.0000001)
        }
    }
}
