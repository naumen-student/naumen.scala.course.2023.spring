import utest._
import scala.collection.SortedSet
import Exercises._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assertDivBy3Or7(1, 3, Seq(3))
            assertDivBy3Or7(7, 9, Seq(7, 9))
            assertDivBy3Or7(5, 9, Seq(6, 7, 9))
            assertDivBy3Or7(0, 100, Seq(
                0, 3, 6, 7, 9, 
                12, 14, 15, 18, 
                21, 24, 27, 28, 
                30, 33, 35, 36, 
                39, 42, 45, 48, 
                49, 51, 54, 56, 
                57, 60, 63, 66, 
                69, 70, 72, 75, 
                77, 78, 81, 84,
                87, 90, 91, 93, 
                96, 98, 99)
            )
            assertDivBy3Or7(0, 0, Seq(0))
            assertDivBy3Or7(10, 0, Seq())
            assertDivBy3Or7(-9, 0, Seq(-9, -7, -6, -3, 0))
            assertDivBy3Or7(-9, -7, Seq(-9, -7))
            assertDivBy3Or7(-20, -10, Seq(-18, -15, -14, -12))
        }

        'test_sumOfDivBy3Or5 - {
            assertSumOfDivBy3Or5(0, 0, Seq(0))
            assertSumOfDivBy3Or5(10, 0, Seq(0))
            assertSumOfDivBy3Or5(0, 10, Seq(0, 3, 5, 6, 9, 10))
            assertSumOfDivBy3Or5(12, 15, Seq(12, 15))
            assertSumOfDivBy3Or5(-10, 0, Seq(-10, -9, -6, -5, -3, 0))
            assertSumOfDivBy3Or5(-15, -12, Seq(-15, -12))
        }

        'test_primeFactor - {
            assertPrimeFactor(0, SortedSet())
            assertPrimeFactor(1, SortedSet())
            assertPrimeFactor(2, SortedSet(2))
            assertPrimeFactor(3, SortedSet(3))
            assertPrimeFactor(80, SortedSet(2, 5))
            assertPrimeFactor(98, SortedSet(2, 7))
            assertPrimeFactor(3276, SortedSet(2, 3, 7, 13))
            assertPrimeFactor(123456789, SortedSet(3, 3607, 3803))
            assertPrimeFactor(987654321, SortedSet(3, 17, 379721))
            assertPrimeFactor(452136510, SortedSet(2, 3, 5, 7, 127, 5651))
        }

        'test_sumScalars - {
            assertSumScalars(0, 0, 0, 0, 0, 0, 0, 0, 0)
            assertSumScalars(1, 1, 1, 1, 0, 0, 0, 0, 2 + 0)
            assertSumScalars(0, 0, 0, 0, 1, 1, 1, 1, 0 + 2)
            assertSumScalars(1, 0, 1, 0, 0, 1, 0, 1, 1 + 1)
            assertSumScalars(1, 1, 1, 1, 0, 1, 0, 1, 2 + 1)
            assertSumScalars(1, 0, 1, 0, 1, 1, 1, 1, 1 + 2)
            assertSumScalars(-1, -1, 1, 1, 1, 1, -1, -1, -2 + -2)
            assertSumScalars(-2, 1, 1, 1, 1, -2, 3, -2, -1 + 7)
        }

        'test_sumCosines - {
            assertSumCosines(0, 0, 0, 0, 0, 0, 0, 0, Double.NaN)
            assertSumCosines(1, 0, 1, 0, 0, 0, 0, 0, Double.NaN)
            assertSumCosines(0, 0, 0, 0, 1, 0, 1, 0, Double.NaN)
            assertSumCosines(1, 0, 0, 1, 1, 0, 0, 1, 0)
            assertSumCosines(1, 0, 1, 0, 1, 0, 0, 1, 1)
            assertSumCosines(1, 0, 1, 0, 1, 0, 1, 0, 2)
            assertSumCosines(1, 0, 1, 0, 1, 0, -1, 0, 0)
            assertSumCosines(1, 0, 0, 1, 1, 0, -1, 0, -1)
            assertSumCosines(1, 0, -1, 0, -1, 0, 1, 0, -2)
            assertSumCosines(1, 0, 1, 1, 1, 0, 0, 1, math.sqrt(2) / 2)
            assertSumCosines(1, 0, -1, -1, 1, 0, 0, 1, -math.sqrt(2) / 2)
            assertSumCosines(1, 0, 1, 1, 1, 0, 1, 1, math.sqrt(2))
            assertSumCosines(1, 0, -1, -1, 1, 0, -1, -1, -math.sqrt(2))
        }

        'test_sortByHeavyweight - {
            assertSortByHeavyweight(Seq(("a", 0, 0), ("b", 1, 1)), Seq(0, 1))
            assertSortByHeavyweight(Seq(("a", 1, 1), ("b", 0, 0)), Seq(1, 0))
            assertSortByHeavyweight(Seq(("a", 1, 0.1), ("b", 1, 0.2)), Seq(0, 1))
            assertSortByHeavyweight(Seq(("a", 1, 0.3), ("b", 1, 0.2), ("c", 1, 0.1)), Seq(2, 1, 0))
            assertSortByHeavyweight(Seq(("a", 1, 0.3), ("b", 1, 0.1), ("c", 1, 0.2)), Seq(1, 2, 0))
            assertSortByHeavyweight(Seq(("a", 1, 1), ("b", 2, 1), ("c", 3, 1)), Seq(0, 1, 2))
            assertSortByHeavyweight(Seq(("a", 3, 1), ("b", 2, 1), ("c", 1, 1)), Seq(2, 1, 0))

            assertSortByHeavyweightWithGivenBalls()
        }
    }

    private def assertDivBy3Or7(from: Int, to: Int, expected: Seq[Int]): Unit = {
        assert(divBy3Or7(from, to) == expected)
    }

    private def assertSumOfDivBy3Or5(from: Int, to: Int, expected: Seq[Int]): Unit = {
        assert(sumOfDivBy3Or5(from, to) == expected.sum)
    }

    private def assertPrimeFactor(number: Int, expected: SortedSet[Int]): Unit = {
        val absolute = math.abs(number)
        val orderedSequence = expected.toSeq

        val actualWhenAbsolute = primeFactor(absolute)
        val actualWhenNegative = primeFactor(-absolute)

        assert(actualWhenAbsolute == orderedSequence)
        assert(actualWhenNegative == orderedSequence)
    }

    private def assertSumScalars(
        rx0: Int, ry0: Int,
        rx1: Int, ry1: Int, 
        lx0: Int, ly0: Int, 
        lx1: Int, ly1: Int, 
        expected: Double
    ): Unit =
        assertSumByFunc(sumScalars, rx0, ry0, rx1, ry1, lx0, ly0, lx1, ly1, expected)

    private def assertSumCosines(
        rx0: Int, ry0: Int,
        rx1: Int, ry1: Int, 
        lx0: Int, ly0: Int, 
        lx1: Int, ly1: Int, 
        expected: Double
    ): Unit = 
        assertSumByFunc(sumCosines, rx0, ry0, rx1, ry1, lx0, ly0, lx1, ly1, expected)

    private def assertSumByFunc(
        func: (Vector2D, Vector2D, Vector2D, Vector2D) => Double,
        rx0: Int, ry0: Int,
        rx1: Int, ry1: Int, 
        lx0: Int, ly0: Int, 
        lx1: Int, ly1: Int, 
        expected: Double
    ): Unit = {

        val r0 = Vector2D(rx0, ry0)
        val r1 = Vector2D(rx1, ry1)

        val l0 = Vector2D(lx0, ly0)
        val l1 = Vector2D(lx1, ly1)

        val actual = func(r0, r1, l0, l1)

        assertDouble(expected, actual)
    }

    private def assertSortByHeavyweight(
        balls: Seq[(String, Int, Double)], expectedIndexes: Seq[Int]
    ): Unit = {
        val expected = expectedIndexes.map(idx => balls(idx)._1)
        val actual = sortByHeavyweight(balls.map(s => s._1 -> (s._2, s._3)).toMap)

        assert(expected == actual)
    }

    private def assertSortByHeavyweightWithGivenBalls(): Unit = {
        val expected = Seq(
            "Tin", "Platinum", "Nickel", 
            "Aluminum", "Titanium", "Lead", 
            "Sodium", "Uranium", "Gold", 
            "Tungsten", "Zirconium", 
            "Chrome", "Iron", "Copper", 
            "Silver", "Plutonium", "Cobalt", 
            "Cesium", "Calcium", "Lithium", 
            "Magnesium", "Potassium", "Graphite"
        )
        
        val balls = expected.map(name => {
            val values = Exercises.balls(name)
            (name, values._1, values._2)
        })

        assertSortByHeavyweight(balls, 0 until expected.length)
    }

    private def assertDouble(expected: Double, actual: Double): Unit = 
        assert(actual.isNaN && expected.isNaN || math.abs(actual - expected) <= 1e-9)
}
