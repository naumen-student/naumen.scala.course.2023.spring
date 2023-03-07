import utest._
import Exercises.Vector2D

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(0, 0) == 0)
            assert(Exercises.sumOfDivBy3Or5(0, 10) == 33)
            assert(Exercises.sumOfDivBy3Or5(10, 5) == 0)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2,5))
            assert(Exercises.primeFactor(98) == Seq(2,7))
            assert(Exercises.primeFactor(1) == Seq())
        }

        'test_sumScalars - {
            assert(Exercises.sumScalars(Vector2D(2, 2), Vector2D(2, 2), Vector2D(3, 3), Vector2D(3, 3)) == 26)
            assert(Exercises.sumScalars(Vector2D(7, -4), Vector2D(-8, 3), Vector2D(7, 4), Vector2D(8, 3)) == 0)
            assert(Exercises.sumScalars(Vector2D(-1, -1), Vector2D(5, 5), Vector2D(-1, -1), Vector2D(5, 5)) == -20)
        }

        'test_sumCosines - {
            assert(Exercises.sumCosines(Vector2D(0, 1), Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0)) == 0)
            assert(Exercises.sumCosines(Vector2D(0, 1), Vector2D(1, 0), Vector2D(0, 1), Vector2D(0, 1)) == 1)
        }

        'test_sortByHeavyweight - {
            val balls1 = Map(
                "3" -> (3, 2.5),
                "1" -> (1, 2.5),
                "2" -> (2, 2.5)
            )
            val balls2 = Map(
                "3" -> (1, 10.0),
                "1" -> (1, 1.0),
                "2" -> (1, 5.0)
            )
            assert(Exercises.sortByHeavyweight(balls1) == Seq("1", "2", "3"))
            assert(Exercises.sortByHeavyweight(balls2) == Seq("1", "2", "3"))
            assert(Exercises.sortByHeavyweight().head == "Tin")
        }
    }
}
