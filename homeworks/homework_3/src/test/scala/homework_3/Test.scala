package homework_3

import utest._

object Test extends TestSuite {
    val tests: Tests = Tests {
        val trueStr = "правда"
        val falseStr = "ложь"

        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(10) == "10")
            assert(Exercises.prettyBooleanFormatter1("10") == "10")
        }
        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(10) == "10")
            assert(Exercises.prettyBooleanFormatter2("10") == "10")
        }
        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(10) == "10")
            assert(Exercises.prettyBooleanFormatter3("10") == "10")
        }

        'max_1 - {
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Seq(3, 2, 1)) == 3)
            assert(Exercises.max1(Seq(-1, 3, 1)) == 3)
            assert(Exercises.max1(Seq(2)) == 2)
            assert(Exercises.max1(Seq()) == 0)
        }
        'max_2 - {
            assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3))
            assert(Exercises.max2(Seq(3, 2, 1)) == Seq(3))
            assert(Exercises.max2(Seq(-1, 3, 1)) == Seq(3))
            assert(Exercises.max2(Seq(2)) == Seq(2))
            assert(Exercises.max2(Seq()) == Seq())
        }
        'max_3 - {
            assert(Exercises.max3(Seq(1, 2, 3)).get == 3)
            assert(Exercises.max3(Seq(3, 2, 1)).get == 3)
            assert(Exercises.max3(Seq(-1, 3, 1)).get == 3)
            assert(Exercises.max3(Seq(2)).get == 2)
            assert(Exercises.max3(Seq()).isEmpty)
        }

        'sum_1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(-1, 1) == 0)
            assert(Exercises.sum1(-10, 1) == -9)
        }
        'sum_2 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum2(-1, 1) == 0)
            assert(Exercises.sum2(-10, 1) == -9)
        }
        'sum_3 - {
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum3(0, 0) == 0)
            assert(Exercises.sum3(-1, 1) == 0)
            assert(Exercises.sum3(-10, 1) == -9)
        }
    }
}