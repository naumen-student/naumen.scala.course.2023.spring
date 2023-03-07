import Exercises.Vector2D
import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'sumOfDivBy3Or5 - {
            // zero len
            assert(Exercises.sumOfDivBy3Or5(0, 0) == 0)
            assert(Exercises.sumOfDivBy3Or5(3, 3) == 3)
            // no divs
            assert(Exercises.sumOfDivBy3Or5(0, 1) == 0)
            assert(Exercises.sumOfDivBy3Or5(7, 8) == 0)
            // normal input
            assert(Exercises.sumOfDivBy3Or5(0, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(0, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(0, 15) == 60)
            assert(Exercises.sumOfDivBy3Or5(0, 16) == 60)
        }

        'primeFactor - {
            assert(Exercises.primeFactor(0) == Seq())
            assert(Exercises.primeFactor(1) == Seq())
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(3) == Seq(3))
            assert(Exercises.primeFactor(4) == Seq(2))
            assert(Exercises.primeFactor(6) == Seq(2, 3))
            assert(Exercises.primeFactor(30) == Seq(2, 3, 5))
        }

        'sumByFunc - {
            // scalar
            assert(Exercises.sumScalars(Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0)) == 0)
            assert(Exercises.sumScalars(Vector2D(1, 1), Vector2D(1, 1), Vector2D(0, 0), Vector2D(0, 0)) == 2)
            assert(Exercises.sumScalars(Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1)) == 4)
            assert(Exercises.sumScalars(Vector2D(3, 21), Vector2D(4, 13), Vector2D(2, 3), Vector2D(7, 4)) == 311)
            // cos
            assert(Math.abs(Exercises.sumCosines(Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1)) - 2) < 0.001)
            assert(Math.abs(Exercises.sumCosines(Vector2D(3, 21), Vector2D(4, 13), Vector2D(2, 3), Vector2D(7, 4)) - 1.882) < 0.001)
        }

        'sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map()) == Seq())
            assert(Exercises.sortByHeavyweight(Map(
                "Heavy" -> (10, 10),
                "Light" -> (1, 1),
                "Medium" -> (10, 1))
            ) == Seq("Light", "Medium", "Heavy"))
            assert(Exercises.sortByHeavyweight(Map(
                "VeryLight" -> (3, 3),
                "Light" -> (100, 100),
                "NotLight" -> (999, 999))
            ) == Seq("VeryLight", "Light", "NotLight"))
        }
    }
}
