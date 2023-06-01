package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        "test_example" - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }

        "prettyBooleanFormatter1" - {
            val trueStr = "правда"
            val falseStr = "ложь"

            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1("правда") == trueStr)
        }

        "prettyBooleanFormatter2" - {
            val trueStr = "правда"
            val falseStr = "ложь"

            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(128) == "128")
        }

        "prettyBooleanFormatter3" - {
            val trueStr = "правда"
            val falseStr = "ложь"

            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(1024) == "1024")
        }

        "test_max1" - {
            assert(Exercises.max1(Seq(2, 1, 3, 7, 5)) == 7)
            assert(Exercises.max1(Seq(1, 2, 5, -4)) == 5)
            assert(Exercises.max1(Seq(8, 6, 11, 55, 21)) == 55)
            assert(Exercises.max1(null) == 0)
        }

        "test_max2" - {
            assert(Exercises.max2(Seq(2, 1, 3, 7, 5)) == Seq(7))
            assert(Exercises.max2(Seq(1, 2, 5, -4)) == Seq(5))
            assert(Exercises.max2(Seq(8, 6, 11, 55, 21)) == Seq(55))
            assert(Exercises.max2(null) == Seq.empty)
        }

        "test_max3" - {
            assert(Exercises.max3(Seq(2, 1, 3, 7, 5)).contains(7))
            assert(Exercises.max3(Seq(1, 2, 5, -4)).contains(5))
            assert(Exercises.max3(Seq(8, 6, 11, 55, 21)).contains(55))
            assert(Exercises.max3(null).isEmpty)
        }
    }
}
