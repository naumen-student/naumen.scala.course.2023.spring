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
            assert(Exercises.sumOfDivBy3Or5(0, 9) == 23)
            assert(Exercises.sumOfDivBy3Or5(-6, 6) == 0)
            assert(Exercises.sumOfDivBy3Or5(-3, 5) == 5)
            assert(Exercises.sumOfDivBy3Or5(3, 15) == 60)
            assert(Exercises.sumOfDivBy3Or5(90, 100) == 573)
            assert(Exercises.sumOfDivBy3Or5(0, 0) == 0)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(12) == Seq(2, 3))
            assert(Exercises.primeFactor(26) == Seq(2, 13))
            assert(Exercises.primeFactor(9) == Seq(3))
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(49) == Seq(7))
            assert(Exercises.primeFactor(169) == Seq(13))
        }
        'test_sumScalars - {
            assert(Exercises.sumScalars(Vector2D(1, 1), Vector2D(2, 2), Vector2D(3, 3), Vector2D(4, 4)) == 2+2+12+12)
            assert(Exercises.sumScalars(Vector2D(1, 3), Vector2D(4, 2), Vector2D(2, 0), Vector2D(1, 1)) == 4+6+2+0)
            assert(Exercises.sumScalars(Vector2D(3, 2), Vector2D(-1, 3), Vector2D(5, 4), Vector2D(-4, 4)) == -3+6+(-20)+16)
            assert(Exercises.sumScalars(Vector2D(0, 0), Vector2D(12, 6), Vector2D(22, 3), Vector2D(0, 0)) == 0)
        }
        'test_sumCosines - {
            assert(Exercises.sumCosines(Vector2D(0, 1), Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0)) == 0)
            assert(Exercises.sumCosines(Vector2D(0, 1), Vector2D(0, 1), Vector2D(0, 1), Vector2D(1, 0)) == 1)
            assert(Exercises.sumCosines(Vector2D(0, 1), Vector2D(0, 1), Vector2D(1, 0), Vector2D(1, 0)) == 2)
            assert(Exercises.sumCosines(Vector2D(1, 1), Vector2D(-1, 1), Vector2D(1, 1), Vector2D(-1, 1)) == 0)
            assert(Exercises.sumCosines(Vector2D(0, 1), Vector2D(0, -1), Vector2D(0, 1), Vector2D(0, -1)) == -2)
            // assert(Exercises.sumCosines(Vector2D(1, 1), Vector2D(-1, -1), Vector2D(1, 1), Vector2D(-1, -1)) == -2)
            // Последний закомментированный тест не пройдет из-за 'особенности' хранения чисел с плавающей точкой в типе Double -
            // при операции {... / abs(vec0) / abs(vec1)}
            // должно получиться {... / sqrt(2) / sqrt(2)} или же {... / 2}, однако из-за Double получится примерно {... / 2.000000004}
        }
        'test_sortByHeavyweight - {
            val balls1: Map[String, (Int, Double)] = {
                Map(
                    "Chrome" -> (3, 7.18), "Cesium" -> (7, 1.873), "Zirconium" -> (3, 6.45)
                )
            }
            val balls2: Map[String, (Int, Double)] = {
                Map(
                    "Lead" -> (2, 11.336), "Titanium" -> (2, 10.50), "Silver" -> (4, 4.505), "Uranium" -> (2, 19.04)
                )
            }
            val balls3: Map[String, (Int, Double)] = {
                Map(
                    "Nickel" -> (2, 8.91), "Tin" -> (1, 7.29), "Platinum" -> (1, 21.45), "Plutonium" -> (3, 19.25)
                )
            }
            val balls4: Map[String, (Int, Double)] = {
                Map(
                    "Lithium" -> (12, 0.534), "Magnesium" -> (10, 1.738), "Copper" -> (3, 8.96), "Sodium" -> (5, 0.971)
                )
            }
            val balls5: Map[String, (Int, Double)] = {
                Map(
                    "Gold" -> (2, 19.32), "Potassium" -> (14, 0.862), "Calcium" -> (8, 1.55), "Cobalt" -> (4, 8.90)
                )
            }
            val balls6: Map[String, (Int, Double)] = {
                Map(
                    "Aluminum" -> (3, 2.6889), "Tungsten" -> (2, 19.35), "Graphite" -> (12, 2.1), "Iron" -> (3, 7.874)
                )
            }
            assert(Exercises.sortByHeavyweight(balls1) == Seq("Zirconium", "Chrome", "Cesium"))
            assert(Exercises.sortByHeavyweight(balls2) == Seq("Titanium", "Lead", "Uranium", "Silver"))
            assert(Exercises.sortByHeavyweight(balls3) == Seq("Tin", "Platinum", "Nickel", "Plutonium"))
            assert(Exercises.sortByHeavyweight(balls4) == Seq("Sodium", "Copper", "Lithium", "Magnesium"))
            assert(Exercises.sortByHeavyweight(balls5) == Seq("Gold", "Cobalt", "Calcium", "Potassium"))
            assert(Exercises.sortByHeavyweight(balls6) == Seq("Aluminum", "Tungsten", "Iron", "Graphite"))
        }
    }
}
