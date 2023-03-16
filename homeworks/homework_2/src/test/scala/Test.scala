import utest._
import Exercises.Vector2D
import Exercises.balls

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(5, 9) == 20)
            assert(Exercises.sumOfDivBy3Or5(0, 100) == 2418)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(111) == Seq(3, 37))
            assert(Exercises.primeFactor(30) == Seq(2, 3, 5))
            assert(Exercises.primeFactor(197) == Seq(197))
            assert(Exercises.primeFactor(1) == Seq())
        }

        'test_sumByFunc_scalar - {
            assert(Exercises.sumScalars(Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0)) == 0)
            assert(Exercises.sumScalars(Vector2D(1, 0), Vector2D(0, 1), Vector2D(0, -1), Vector2D(-1, 0)) == 0)
            assert(Exercises.sumScalars(Exercises.Vector2D(0, 1), Vector2D(0, 1), Vector2D(0, 1), Vector2D(0, 1)) == 2)
        }

        'test_sumByFunc_sumCos - {
            assert(Exercises.sumCosines(Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0), Vector2D(0, 1)) == 0)
            assert(Exercises.sumCosines(Vector2D(1, 0), Vector2D(1, 0), Vector2D(1, 0), Vector2D(1, 0)) == 2)
            assert(Exercises.sumCosines(Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0), Vector2D(-1, 0)) == -1)
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(balls) == Seq(
                "Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten",
                "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium",
                "Lithium", "Magnesium", "Potassium", "Graphite")
            )
            val balls_1: Map[String, (Int, Double)] =
                Map(
                    "Aluminum" -> (1,   2.6889), "Tungsten" ->  (4,   19.35), "Lithium" -> (6, 0.534)
                )
            assert(Exercises.sortByHeavyweight(balls_1) == Seq("Aluminum", "Lithium", "Tungsten"))
        }
    }
}
