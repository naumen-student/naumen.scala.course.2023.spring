import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 25) == 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 + 20 + 21 + 24 + 25)
            assert(Exercises.sumOfDivBy3Or5(15, 30) == 15 + 18 + 20 + 21 + 24 + 25 + 27 + 30)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(12) == Seq(2, 3))
            assert(Exercises.primeFactor(16) == Seq(4, 4))
            assert(Exercises.primeFactor(100) == Seq(2, 5))
        }
        'test_sumScalars - {
            assert(
                Exercises.sumScalars(
                    Exercises.Vector2D(10, 15), Exercises.Vector2D(20, 30),
                    Exercises.Vector2D(1, 15), Exercises.Vector2D(4, 7)
                ) == 650 + 109)
        }
        'test_sumCosines - {
            assert(Exercises.sumCosines(
                Exercises.Vector2D(5, 8), Exercises.Vector2D(10, 16),
                Exercises.Vector2D(3, 17), Exercises.Vector2D(2, 6)
            ) == Exercises.cosBetween(Exercises.Vector2D(5, 8), Exercises.Vector2D(10, 16))
              + Exercises.cosBetween(Exercises.Vector2D(3, 17), Exercises.Vector2D(2, 6))
            )
        }
        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(balls) == Seq(
                "Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten",
                "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium",
                "Lithium", "Magnesium", "Potassium", "Graphite")
            )
            val balls_1: Map[String, (Int, Double)] =
                Map(
                    "Aluminum" -> (1, 2.6889),   "Gold" ->     (2,   19.32), "Lithium" -> (6, 0.534)
                )
            assert(Exercises.sortByHeavyweight(balls_1) == Seq("Aluminum", "Lithium", "Gold"))
        }
    }

}
