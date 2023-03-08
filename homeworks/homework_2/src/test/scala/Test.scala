import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 1) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(1, 10) == 33)
            assert(Exercises.sumOfDivBy3Or5(1, 100) == 2418)
            assert(Exercises.sumOfDivBy3Or5(407, 1337) == 378045)
            assert(Exercises.sumOfDivBy3Or5(222, 999) == 221690)
            assert(Exercises.sumOfDivBy3Or5(15, 15) == 15)
            assert(Exercises.sumOfDivBy3Or5(-100, 100) == 0)
            assert(Exercises.sumOfDivBy3Or5(-555, 0) == -72150)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(19) == Seq(19))
            assert(Exercises.primeFactor(1) == Seq())
            assert(Exercises.primeFactor(1000) == Seq(2, 5))
            assert(Exercises.primeFactor(1337) == Seq(7, 191))
            assert(Exercises.primeFactor(223092870) == Seq(2, 3, 5, 7, 11, 13, 17, 19, 23))
            assert(Exercises.primeFactor(223092871) == Seq(317, 703763))
        }
        'test_vectors - {
            assert(Exercises.sumScalars(Exercises.Vector2D(0, 0), Exercises.Vector2D(3, 5), Exercises.Vector2D(4, 4), Exercises.Vector2D(2, 9)) == 44)
            assert(Exercises.sumScalars(Exercises.Vector2D(15, 32), Exercises.Vector2D(2, 81), Exercises.Vector2D(34, 50), Exercises.Vector2D(69, 1337)) == 71818)
            assert(Exercises.sumCosines(Exercises.Vector2D(15, 32), Exercises.Vector2D(2, 81), Exercises.Vector2D(34, 50), Exercises.Vector2D(69, 1337)) == 1.7704683576548823)
            assert(Exercises.sumScalars(Exercises.Vector2D(1, 3), Exercises.Vector2D(3, 7), Exercises.Vector2D(1, 3), Exercises.Vector2D(3, 7)) == 48)
            assert(Exercises.sumCosines(Exercises.Vector2D(1, 3), Exercises.Vector2D(3, 7), Exercises.Vector2D(1, 3), Exercises.Vector2D(3, 7)) == 1.9930915164897591)
            assert(Exercises.sumScalars(Exercises.Vector2D(100500, 100500), Exercises.Vector2D(-1, -1), Exercises.Vector2D(123456789, 123456789), Exercises.Vector2D(2, 3)) == 617082945)
            assert(Exercises.sumCosines(Exercises.Vector2D(100500, 100500), Exercises.Vector2D(-1, -1), Exercises.Vector2D(123456789, 123456789), Exercises.Vector2D(2, 3)) == -0.019419324309079555)
        }
        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Exercises.balls) == Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten", "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"))
        }
    }
}
