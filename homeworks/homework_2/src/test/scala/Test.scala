package scala

import scala.Exercises._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(divBy3Or7(1, 3) == Seq(3))
            assert(divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'sumOfDivBy3Or5 - {
            assert(sumOfDivBy3Or5(1, 3) == 3)
            assert(sumOfDivBy3Or5(5, 9) == 20)
            assert(sumOfDivBy3Or5(0, 100) == 2418)
        }

        'primeFactor - {
            assert(primeFactor(2) == Seq(2))
            assert(primeFactor(1024) == Seq(2))
            assert(primeFactor(55900) == Seq(2,5,13,43))
        }

        'Sum - {
            assert(sumScalars(Vector2D(1, 2),Vector2D(1, 2), Vector2D(1, 2),Vector2D(1, 2)) == 10)
            assert(sumScalars(Vector2D(0, 0),Vector2D(0, 0), Vector2D(0, 0),Vector2D(0, 0)) == 0)
            assert(sumCosines(Vector2D(1, 2),Vector2D(1, 2), Vector2D(1, 2),Vector2D(1, 2)) == 2)
            assert(sumCosines(Vector2D(0,5),Vector2D(0, 2), Vector2D(5, 0),Vector2D(1, 0)) == 2)
        }

        'sortByHeavyweight - {
            assert(sortByHeavyweight(balls) == Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten",
                "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium","Cobalt", "Cesium", "Calcium","Lithium", "Magnesium", "Potassium", "Graphite"))
            assert(sortByHeavyweight( Map("1" -> (1,   1), "2" ->  (2,   2))) == Seq("1", "2"))
        }
    }
}
