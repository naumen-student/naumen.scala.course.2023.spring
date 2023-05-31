import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
    }
    'test_sumOfDivBy3Or5 - {
        assert(Exercises.sumOfDivBy3Or5(1,3) == 3)
        assert(Exercises.sumOfDivBy3Or5(1,5) == 14)
        assert(Exercises.sumOfDivBy3Or5(1,12) == 45)
    }
    'test_primeFactor - {
        assert(Exercises.primeFactor(80) == Seq(2,5))
        assert(Exercises.primeFactor(98) == Seq(2,7))
    }
    'test_sortByHeavyWeight -{
        val s: Seq[String] = Seq("Gold", "Tungsten", "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium",
            "Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Cobalt", "Cesium",
            "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite")
        val balls: Map[String, (Int, Double)] =
            Map(
                "Aluminum" -> (3, 2.6889), "Tungsten" -> (2, 19.35), "Graphite" -> (12, 2.1), "Iron" -> (3, 7.874),
                "Gold" -> (2, 19.32), "Potassium" -> (14, 0.862), "Calcium" -> (8, 1.55), "Cobalt" -> (4, 8.90),
                "Lithium" -> (12, 0.534), "Magnesium" -> (10, 1.738), "Copper" -> (3, 8.96), "Sodium" -> (5, 0.971),
                "Nickel" -> (2, 8.91), "Tin" -> (1, 7.29), "Platinum" -> (1, 21.45), "Plutonium" -> (3, 19.25),
                "Lead" -> (2, 11.336), "Titanium" -> (2, 10.50), "Silver" -> (4, 4.505), "Uranium" -> (2, 19.04),
                "Chrome" -> (3, 7.18), "Cesium" -> (7, 1.873), "Zirconium" -> (3, 6.45)
            )
        assert(Exercises.sortByHeavyweight(balls) == s)
    }
}
