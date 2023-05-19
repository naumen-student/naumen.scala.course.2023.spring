package homework_3

import utest._

object Test extends TestSuite {

  val tests = Tests {

    val trueStr = "правда"
    val falseStr = "ложь"

    'test_prettyBooleanFormatter1 - {
      assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter1(2) == "2")
      assert(Exercises.prettyBooleanFormatter1("String") == "String")
    }

    'test_prettyBooleanFormatter2 - {
      assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter2(3) == "3")
      assert(Exercises.prettyBooleanFormatter2("Scala") == "Scala")
    }

    'test_prettyBooleanFormatter3 - {
      assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter3(123) == "123")
      assert(Exercises.prettyBooleanFormatter3("JAvA") == "JAvA")
    }

    'test_max1 - {
      assert(Exercises.max1(Seq(1, 2, 3, 4, 5, 6, 7, 8)) == 8)
      assert(Exercises.max1(Seq(-1, -2, -3, -4, -5, -6, -7, -8)) == -1)
      assert(Exercises.max1(Seq(0, 0, 0, 0, 0)) == 0)
      assert(Exercises.max1(Seq()) == -1)
    }

    'test_max2 - {
      assert(Exercises.max2(Seq(1, 2, 3, 4, 5, 6, 7, 8)) == Seq(8))
      assert(Exercises.max2(Seq(-1, -2, -3, -4, -5, -6, -7, -8)) == Seq(-1))
      assert(Exercises.max2(Seq(0, 0, 0, 0, 0)) == Seq(0))
      assert(Exercises.max2(Seq()) == Seq())
    }

    'test_max3 - {
      assert(Exercises.max3(Seq(1, 2, 3, 4, 5, 6, 7, 8)).get == 8)
      assert(Exercises.max3(Seq(-1, -2, -3, -4, -5, -6, -7, -8)).get == -1)
      assert(Exercises.max3(Seq(0, 0, 0, 0, 0)).get == 0)
      assert(Exercises.max3(Seq()).isEmpty)
    }

    'test_sum1 - {
      assert(Exercises.sum1(5, 2) == 5 + 2)
      assert(Exercises.sum1(-10, 10) == 10 - 10)
      assert(Exercises.sum1(0, 123) == 123)
    }

    'test_sum2 - {
      assert(Exercises.sum2(3, 2) == 3 + 2)
      assert(Exercises.sum2(-10, 123) == 123 - 10)
      assert(Exercises.sum2(0, -1000) == -1000)
    }

    'test_sum3 - {
      assert(Exercises.sum3(1, 6) == 1 + 6)
      assert(Exercises.sum3(123, -321) == 123 - 321)
      assert(Exercises.sum3(0, -1) == -1)
    }
  }
}
