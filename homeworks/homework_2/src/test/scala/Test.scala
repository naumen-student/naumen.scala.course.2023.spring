import utest._
import Exercises.Vector2D

object Test extends TestSuite {

  val tests = Tests {
    'test_divBy3Or7 - {
      assert(Exercises.divBy3Or7(1, 3) == Seq(3))
      assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
      assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
    }
    'sumOfDivBy3Or5 - {
      assert(Exercises.sumOfDivBy3Or5(1, 10) == 33)
      assert(Exercises.sumOfDivBy3Or5(4, 17) == 57)
      assert(Exercises.sumOfDivBy3Or5(20, 31) == 147)
    }
    'primeFactor - {
      assert(Exercises.primeFactor(2) == Seq(2))
      assert(Exercises.primeFactor(49) == Seq(7))
      assert(Exercises.primeFactor(150) == Seq(2, 3, 5))
    }
    'sumScalars - {
      assert(Exercises.sumScalars(Vector2D(1, 1), Vector2D(2, 2), Vector2D(3, 3), Vector2D(4, 4)) == 28)
      assert(Exercises.sumScalars(Vector2D(0, 0), Vector2D(0, 0), Vector2D(-1, -2), Vector2D(3, 5)) == -13)
      assert(Exercises.sumScalars(Vector2D(4, 5), Vector2D(-3, -4), Vector2D(-6, -2), Vector2D(-2, -10)) == 0)
    }
    'sumCosines - {
      assert(Exercises.sumCosines(Vector2D(1, 0), Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0)) == 1)
      assert(Exercises.sumCosines(Vector2D(1, 1), Vector2D(1, 1), Vector2D(-2, 2), Vector2D(2, -2)) == 0)
      assert(math.abs(Exercises.sumCosines(Vector2D(1, 0), Vector2D(-1, 1), Vector2D(-1, 0), Vector2D(1, -1)) - -math.sqrt(2)) < 0.000001)
    }
    'sortByHeavyweight - {
      assert(Exercises.sortByHeavyweight(Map("a" -> (1, 2), "b" -> (3, 2), "c" -> (1, 2.5))) == Seq("a", "c", "b"))
      assert(Exercises.sortByHeavyweight(Map("a" -> (1, 1), "b" -> (1, 1), "c" -> (1, 1))) == Seq("a", "b", "c"))
      assert(Exercises.sortByHeavyweight() == Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium",
        "Uranium", "Gold", "Tungsten", "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium",
        "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"))
    }
  }
}