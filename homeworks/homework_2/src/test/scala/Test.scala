import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(3, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(0, 15) == 60)
            assert(Exercises.sumOfDivBy3Or5(0, 1) == 0)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(11) == Seq(11))
            assert(Exercises.primeFactor(1000000007) == Seq(1000000007))
        }
        'test_sumScalars - {
            assert(Exercises.sumScalars(
                Exercises.Vector2D(1, 0),
                Exercises.Vector2D(0, 1),
                Exercises.Vector2D(1, 1),
                Exercises.Vector2D(0, 1)
            ) - 1 <= 0.01)
            assert(Exercises.sumScalars(
                Exercises.Vector2D(1, 1),
                Exercises.Vector2D(1, 1),
                Exercises.Vector2D(-1, 1),
                Exercises.Vector2D(-1, 1)
            ) - 4 <= 0.01)
        }
        'test_sumCosines - {
            assert(Exercises.sumCosines(
                Exercises.Vector2D(1, 0),
                Exercises.Vector2D(0, 1),
                Exercises.Vector2D(1, 1),
                Exercises.Vector2D(0, 1)
            ) - 0.7 <= 0.01)
            assert(Exercises.sumCosines(
                Exercises.Vector2D(1, 1),
                Exercises.Vector2D(1, 1),
                Exercises.Vector2D(-1, 1),
                Exercises.Vector2D(-1, 1)
            ) - 2 <= 0.01)
        }
        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight() == Seq(
                "Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead",
                "Sodium", "Uranium", "Gold", "Tungsten", "Zirconium", "Chrome",
                "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium",
                "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"
            ))
        };
    }
}
