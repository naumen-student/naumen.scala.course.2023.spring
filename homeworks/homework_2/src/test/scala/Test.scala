import utest._

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
            assert(Exercises.sumOfDivBy3Or5(25, 60) == 727)
            assert(Exercises.sumOfDivBy3Or5(0, 2) == 0)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(100) == Seq(2, 5))
            assert(Exercises.primeFactor(105) == Seq(3, 5, 7))
            assert(Exercises.primeFactor(9) == Seq(3))
        }
        'test_sumScalars - {
            assert(Exercises.sumScalars(Exercises.Vector2D(1, 3), Exercises.Vector2D(5, 9), Exercises.Vector2D(0, 100), Exercises.Vector2D(25, 60)) == 6032)
            assert(Exercises.sumScalars(Exercises.Vector2D(5, 9), Exercises.Vector2D(1, 3), Exercises.Vector2D(25, 60), Exercises.Vector2D(0, 100)) == 6032)
            assert(Exercises.sumScalars(Exercises.Vector2D(1, 2), Exercises.Vector2D(3, 4), Exercises.Vector2D(5, 6), Exercises.Vector2D(7, 8)) == 94)
            assert(Exercises.sumScalars(Exercises.Vector2D(1, 3), Exercises.Vector2D(5, 7), Exercises.Vector2D(2, 4), Exercises.Vector2D(6, 8)) == 70)
            assert(Exercises.sumScalars(Exercises.Vector2D(0, 3), Exercises.Vector2D(1, 0), Exercises.Vector2D(0, 100), Exercises.Vector2D(25, 0)) == 0)
        }
        'test_sumCosines - {
            assert(Exercises.sumCosines(Exercises.Vector2D(1, 3), Exercises.Vector2D(5, 9), Exercises.Vector2D(0, 100), Exercises.Vector2D(25, 60)) == 1.9059491100112451)
            assert(Exercises.sumCosines(Exercises.Vector2D(5, 9), Exercises.Vector2D(1, 3), Exercises.Vector2D(25, 60), Exercises.Vector2D(0, 100)) == 1.9059491100112447)
            assert(Exercises.sumCosines(Exercises.Vector2D(1, 2), Exercises.Vector2D(3, 4), Exercises.Vector2D(5, 6), Exercises.Vector2D(7, 8)) == 1.9835797185673898)
            assert(Exercises.sumCosines(Exercises.Vector2D(1, 3), Exercises.Vector2D(5, 7), Exercises.Vector2D(2, 4), Exercises.Vector2D(6, 8)) == 1.9396489188218575)
            assert(Exercises.sumCosines(Exercises.Vector2D(0, 3), Exercises.Vector2D(1, 0), Exercises.Vector2D(0, 100), Exercises.Vector2D(25, 0)) == 0)
        }
        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Exercises.balls) == Seq("Tin", "Platinum", "Nickel", "Aluminum",
                "Titanium", "Lead", "Sodium", "Uranium",
                "Gold", "Tungsten", "Zirconium", "Chrome",
                "Iron", "Copper", "Silver", "Plutonium",
                "Cobalt", "Cesium", "Calcium", "Lithium",
                "Magnesium", "Potassium", "Graphite"))
        }
    }
}
