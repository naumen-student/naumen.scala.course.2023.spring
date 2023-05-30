package homework_3

import utest._

object Test extends TestSuite{

  def testPrettyBooleanFormatter(formatter: (Any) => String, argument: Any, expected: String): Unit = {
    val actual = formatter(argument)
    assert(expected == actual)
  }

  def testSum(summator: (Int, Int) => Int, arg1: Int, arg2: Int, expected: Int): Unit = {
    val actual = summator(arg1, arg2)
    assert(expected == actual)
  }

  val tests = Tests {
    'test_prettyBooleanFormatter1 - {
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1, "string", "string")
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1, 1234, "1234")
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1, true, "правда")
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1, false, "ложь")
    }
    'test_prettyBooleanFormatter2 - {
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter2, "string", "string")
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter2, 1234, "1234")
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1, true, "правда")
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1, false, "ложь")
    }
    'test_prettyBooleanFormatter3 - {
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter3, "string", "string")
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter3, 1234, "1234")
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1, true, "правда")
      testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1, false, "ложь")
    }
    'test_max1 - {
      intercept[IllegalArgumentException](Exercises.max1(Seq.empty[Int]))
      assert(Exercises.max1(Seq[Int](1)) == 1)
      assert(Exercises.max1(Seq[Int](3, 1, 7, 3)) == 7)
    }
    'test_max2 - {
      assert(Exercises.max2(Seq.empty[Int]).isEmpty)
      assert(Exercises.max2(Seq[Int](1)) == Seq[Int](1))
      assert(Exercises.max2(Seq[Int](3, 1, 7, 3)) == Seq[Int](7))
    }
    'test_max3 - {
      assert(Exercises.max3(Seq.empty[Int]).isEmpty)
      assert(Exercises.max3(Seq[Int](1)).contains(1))
      assert(Exercises.max3(Seq[Int](3, 1, 7, 3)).contains(7))
    }
    'test_sum1 - {
      testSum(Exercises.sum1, 2, 2, 4)
      testSum(Exercises.sum1, -1, 1, 0)
      testSum(Exercises.sum1, 100500, 123, 100623)
      testSum(Exercises.sum1, 0, 123, 123)
      testSum(Exercises.sum1, 0, 0, 0)
    }
    'test_sum2 - {
      testSum(Exercises.sum2, 2, 2, 4)
      testSum(Exercises.sum2, -1, 1, 0)
      testSum(Exercises.sum2, 100500, 123, 100623)
      testSum(Exercises.sum2, 0, 123, 123)
      testSum(Exercises.sum2, 0, 0, 0)
    }
    'test_sum3 - {
      testSum(Exercises.sum3, 2, 2, 4)
      testSum(Exercises.sum3, -1, 1, 0)
      testSum(Exercises.sum3, 100500, 123, 100623)
      testSum(Exercises.sum3, 0, 123, 123)
      testSum(Exercises.sum3, 0, 0, 0)
    }
  }
}
