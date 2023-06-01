import utest._
import Exercises.Vector2D

object Test extends TestSuite {

    val tests = Tests {
        "test_divBy3Or7" - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        "test_sumOfDivBy3Or5" - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(5, 9) == 20)
            assert(Exercises.sumOfDivBy3Or5(0, 20) == 98)
        }

        "test_primeFactor" - {
            assert(Exercises.primeFactor(35) == Seq(5, 7))
            assert(Exercises.primeFactor(18) == Seq(2, 3))
            assert(Exercises.primeFactor(17) == Seq(17))
            assert(Exercises.primeFactor(512) == Seq(2))
            assert(Exercises.primeFactor(1243) == Seq(11, 113))
            assert(Exercises.primeFactor(69) == Seq(3, 23))
            assert(Exercises.primeFactor(90) == Seq(2, 3, 5))
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(6) == Seq(2, 3))
        }

        "test_sumScalars" - {
            val leftVector0: Vector2D = Vector2D(12, 5)
            val leftVector1: Vector2D = Vector2D(13, 4)
            val rightVector0: Vector2D = Vector2D(5, 4)
            val rightVector1: Vector2D = Vector2D(7, 6)

            val leftScalar: Double = 176
            val rightScalar: Double = 59
            val result: Double = leftScalar + rightScalar
            val EPS: Double = 1.0E-6

            assert(Math.abs(Exercises.sumScalars(leftVector0, leftVector1, rightVector0, rightVector1) - result) < EPS)
        }

        "test_sumCosines" - {
            val leftVector0: Vector2D = Vector2D(12, 5)
            val leftVector1: Vector2D = Vector2D(13, 4)
            val rightVector0: Vector2D = Vector2D(5, 4)
            val rightVector1: Vector2D = Vector2D(7, 6)

            val leftCos: Double = 0.99536748837
            val rightCos: Double = 0.99942594713
            val result: Double = leftCos + rightCos
            val EPS: Double = 1.0E-6

            assert(Math.abs(Exercises.sumCosines(leftVector0, leftVector1, rightVector0, rightVector1) - result) < EPS)
        }

        "test_sortByHeavyweight" - {
            assert(Exercises.sortByHeavyweight() ==
              Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten",
                  "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium",
                  "Lithium", "Magnesium", "Potassium", "Graphite"))
        }
    }
}
