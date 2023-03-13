package homework_3

import homework_3.Exercises._
import utest._

object Test extends TestSuite {

  val prettyBooleanFormattersTestsValues: List[(Any, String)] = List(
    (true, "правда"),
    (false, "ложь"),
    ("строка", "строка"),
    (1, "1"),
    (Some(1), "Some(1)"),
    (None, "None"),
    (List("a", "b", "c"), "List(a, b, c)")
  )

  val tests: Tests = Tests {
    'prettyBooleanFormatter1_test - {
      for (test <- prettyBooleanFormattersTestsValues)
        assert(prettyBooleanFormatter1(test._1) == test._2)
    }
    'prettyBooleanFormatter2_test - {
      for (test <- prettyBooleanFormattersTestsValues)
        assert(prettyBooleanFormatter2(test._1) == test._2)
    }
    'prettyBooleanFormatter3_test - {
      for (test <- prettyBooleanFormattersTestsValues) {
        assert(prettyBooleanFormatter3(test._1) == test._2)
      }
    }
  }
}
