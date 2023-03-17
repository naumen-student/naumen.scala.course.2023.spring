package homework_3

import utest._

object Test extends TestSuite {

  val tests = Tests {
    'test_prettyBooleanFormatter1 - {
      assert(Exercises.prettyBooleanFormatter1(true) == "правда")
      assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
      assert(Exercises.prettyBooleanFormatter1(123) == "123")
      assert(Exercises.prettyBooleanFormatter1(List(1, 2, 3)) == "List(1, 2, 3)")
      assert(Exercises.prettyBooleanFormatter1("123") == "123")
    }
    'test_prettyBooleanFormatter2 - {
      assert(Exercises.prettyBooleanFormatter2(true) == "правда")
      assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
      assert(Exercises.prettyBooleanFormatter2(123) == "123")
      assert(Exercises.prettyBooleanFormatter2(List(1, 2, 3)) == "List(1, 2, 3)")
      assert(Exercises.prettyBooleanFormatter2("123") == "123")
    }
    'test_prettyBooleanFormatter3 - {
      assert(Exercises.prettyBooleanFormatter3(true) == "правда")
      assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
      assert(Exercises.prettyBooleanFormatter3(123) == "123")
      assert(Exercises.prettyBooleanFormatter3(List(1, 2, 3)) == "List(1, 2, 3)")
      assert(Exercises.prettyBooleanFormatter3("123") == "123")
    }
    'test_max1 - {
      intercept[IllegalArgumentException](Exercises.max1(Seq.empty[Int]))
      assert(Exercises.max1(Seq(1, 2, 3)) == 3)
      assert(Exercises.max1(Seq(1)) == 1)
    }
    'test_max2 - {
      assert(Exercises.max2(Seq.empty[Int]) == Seq.empty[Int])
      assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3))
      assert(Exercises.max2(Seq(1)) == Seq(1))
    }
    'test_max3 - {
      assert(Exercises.max3(Seq.empty[Int]).isEmpty)
      assert(Exercises.max3(Seq(1, 2, 3)).contains(3))
      assert(Exercises.max3(Seq(1)).contains(1))
    }
    'test_sum1 - {
      assert(Exercises.sum1(1, 2) == 3)
    }
    'test_sum2 - {
      assert(Exercises.sum2(1, 2) == 3)
    }
    'test_sum3 - {
      assert(Exercises.sum3(1, 2) == 3)
    }
  }
}