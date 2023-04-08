package homework_3

import homework_3.Exercises._
import utest._

import scala.util.Random

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

  val sumTestsValues: List[(Int, Int, Int)] = List(
    (0, 0, 0 + 0),
    (5, 5, 5 + 5),
    (2, 4, 2 + 4),
    (-1, 3, -1 + 3),
    (-1, -5, -1 + -5)
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

    'max1_shouldThrowException_onEmptyCollection - {
      try {
        max1(Seq.empty)
        assert(false)
      } catch {
        case _: UnsupportedOperationException => ()
      }
    }
    'max1_shouldReturnOnlyElementOfCollection - {
      val collection = Seq(1)
      assert(max1(collection) == 1)
    }
    'max1_shouldReturnMaxElementOfCollection - {
      val collection = Seq(1, 3, 2)
      assert(max1(collection) == 3)
    }

    'max2_shouldReturnEmptySeq_onEmptyCollection - {
      assert(max2(Seq.empty) == Seq.empty)
    }
    'max2_shouldReturnOnlyElementOfCollection - {
      val collection = Seq(1)
      assert(max2(collection) == Seq(1))
    }
    'max2_shouldReturnMaxElementOfCollection - {
      val collection = Seq(1, 3, 2)
      assert(max2(collection) == Seq(3))
    }

    'max3_shouldReturnNone_onEmptyCollection - {
      assert(max3(Seq.empty).isEmpty)
    }
    'max3_shouldReturnOnlyElementOfCollection - {
      val collection = Seq(1)
      assert(max3(collection).contains(1))
    }
    'max3_shouldReturnMaxElementOfCollection - {
      val collection = Seq(1, 3, 2)
      assert(max3(collection).contains(3))
    }

    'sum1_test - {
      for (test <- sumTestsValues) {
        assert(sum1(test._1, test._2) == test._3)
      }
    }
    'sum1_randomTest - {
      val rnd = Random
      for (_ <- 1 to 100) {
        val x = rnd.nextInt
        val y = rnd.nextInt
        assert(sum1(x, y) == x + y)
      }
    }
    'sum2_test - {
      for (test <- sumTestsValues) {
        assert(sum2(test._1, test._2) == test._3)
      }
    }
    'sum2_randomTest - {
      val rnd = Random
      for (_ <- 1 to 100) {
        val x = rnd.nextInt
        val y = rnd.nextInt
        assert(sum2(x, y) == x + y)
      }
    }
    'sum3_test - {
      for (test <- sumTestsValues) {
        assert(sum3(test._1, test._2) == test._3)
      }
    }
    'sum3_randomTest - {
      val rnd = Random
      for (_ <- 1 to 100) {
        val x = rnd.nextInt
        val y = rnd.nextInt
        assert(sum3(x, y) == x + y)
      }
    }
  }
}
