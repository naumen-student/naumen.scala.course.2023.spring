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

        'test_sortByHeavyweight - {
            val balls1: Map[String, (Int, Double)] =
                Map(
                    "Aluminum" -> (3, 2.6889), "Tungsten" -> (2, 19.35), "Graphite" -> (12, 2.1), "Iron" -> (3, 7.874),
                    "Gold" -> (2, 19.32), "Potassium" -> (14, 0.862), "Calcium" -> (8, 1.55), "Cobalt" -> (4, 8.90),
                    "Lithium" -> (12, 0.534), "Magnesium" -> (10, 1.738), "Copper" -> (3, 8.96), "Sodium" -> (5, 0.971),
                    "Nickel" -> (2, 8.91), "Tin" -> (1, 7.29), "Platinum" -> (1, 21.45), "Plutonium" -> (3, 19.25),
                    "Lead" -> (2, 11.336), "Titanium" -> (2, 10.50), "Silver" -> (4, 4.505), "Uranium" -> (2, 19.04),
                    "Chrome" -> (3, 7.18), "Cesium" -> (7, 1.873), "Zirconium" -> (3, 6.45)
                )
            val balls2: Map[String, (Int, Double)] =
                Map(
                    "Aluminum" -> (3, 2.6889), "Tungsten" -> (3, 19.35), "Graphite" -> (3, 2.1), "Iron" -> (3, 7.874)
                )
            val balls3: Map[String, (Int, Double)] =
                Map(
                    "Gold" -> (1, 19.32), "Potassium" -> (100, 0.862), "Calcium" -> (8, 1.55), "Cobalt" -> (10, 8.90)
                )
            assert(Exercises.sortByHeavyweight(balls1) == Seq(
                "Tin", "Platinum", "Nickel", "Aluminum", "Titanium",
                "Lead", "Sodium", "Uranium", "Gold", "Tungsten",
                "Zirconium", "Chrome", "Iron", "Copper", "Silver",
                "Plutonium", "Cobalt", "Cesium", "Calcium",
                "Lithium", "Magnesium", "Potassium", "Graphite"))
            assert(Exercises.sortByHeavyweight(balls2) == Seq("Graphite", "Aluminum", "Iron", "Tungsten"))
            assert(Exercises.sortByHeavyweight(balls3) == Seq("Gold", "Calcium", "Cobalt", "Potassium"))
        }
    }
}
