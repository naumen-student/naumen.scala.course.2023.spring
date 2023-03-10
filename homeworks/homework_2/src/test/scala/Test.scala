import utest._
import Exercises.Vector2D

object Test extends TestSuite{

  val tests = Tests {
    'test_divBy3Or7 - {
      assert(Exercises.divBy3Or7(1, 3) == Seq(3))
      assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
      assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
    }
    'test_sumOfDivBy3Or5' - {
      assert(Exerсises.sumOfDivBy3Or5(1, 3) == 3)
      assert(Exerсises.sumOfDivBy3Or5(5, 9) == 20)
      assert(Exerсises.sumOfDivBy3Or5(0, 100) == 2418)
    }
    'test_primeFactor' - {
      assert(Excercises.primeFactor(14) == Seq(2, 7))
      assert(Excercises.primeFactor(1) == Seq())
      assert(Excercises.primeFactor(3) == Seq(3))
      assert(Excercises.primeFactor(100) == Seq(2, 2, 5, 5))
    }
    'sumScalars' - {
      assert(Excercises.sumScalars(Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0)) == 0)
      assert(Exercises.sumScalars(Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 1)) == 0)
      assert(Exercises.sumScalars(Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1)) == 2)
      assert(Exercises.sumScalars(Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0)) == 0)
      assert(Exercises.sumScalars(Exercises.Vector2D(1, 1), Exercises.Vector2D(1, 1), Exercises.Vector2D(2, 2), Exercises.Vector2D(2, 2)) == 10)
    }
    'sumCosines'- {
      assert(Exercises.sumCosines(Exercises.Vector2D(0, 1), Exercises.Vector2D(1, 0), Exercises.Vector2D(0, 1), Exercises.Vector2D(1, 0)) == 0)
      assert(Exercises.sumCosines(Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1)) == 2)
    }
    'sortByHeavyweight' - {
      assert(Exerсises.sortByHeavyweight(
        Map("Tungsten" -> (3, 2.6889), "Aluminium" -> (2, 19.35))) == Seq("Tungsten", "Aluminum")
      )
      assert(Exercises.sortByHeavyweight(
        Map("Iron" -> (3,   7.874), "Aluminum" -> (3,   2.6889))
      ) == Seq("Aluminum", "Iron"))
    }
  }
}
