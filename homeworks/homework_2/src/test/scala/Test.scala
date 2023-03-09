import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(5, 9) == 20)
            assert(Exercises.sumOfDivBy3Or5(3, 9) == 23)
            assert(Exercises.sumOfDivBy3Or5(12, 29) == 162)
        }
        'primeFactor - {
            assert(Exercises.primeFactor(23) == Set(23))
            assert(Exercises.primeFactor(80) == Set(2,5))
            assert(Exercises.primeFactor(98) == Set(2,7))
        }
        'sumScalars - {
            assert(Exercises.sumScalars(Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0),Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0)) == 0)
            assert(Exercises.sumScalars(Exercises.Vector2D(128, 96), Exercises.Vector2D(47, 16),Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0)) == 7552)
            assert(Exercises.sumScalars(Exercises.Vector2D(128, 96), Exercises.Vector2D(47, 16),Exercises.Vector2D(34, 75), Exercises.Vector2D(50, 78)) == 7552+7550)
        }
        'sumCosines - {
            assert(Exercises.sumCosines(Exercises.Vector2D(1, 0), Exercises.Vector2D(0, 1),Exercises.Vector2D(1, 0), Exercises.Vector2D(0, 1)) == 0)
            assert(Exercises.sumCosines(Exercises.Vector2D(1, 0), Exercises.Vector2D(1, 0), Exercises.Vector2D(1, 0), Exercises.Vector2D(0, 1)) == 1)
            assert(Exercises.sumCosines(Exercises.Vector2D(1, 0), Exercises.Vector2D(0, 1), Exercises.Vector2D(1, 0), Exercises.Vector2D(1, 0)) == 1)
        }
    }
}
