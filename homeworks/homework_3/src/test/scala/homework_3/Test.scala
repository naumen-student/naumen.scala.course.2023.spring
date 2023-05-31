package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter - {
            val trueStr = "правда"
            val falseStr = "ложь"

            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1("true") == "true")
            assert(Exercises.prettyBooleanFormatter2("false") == "false")
            assert(Exercises.prettyBooleanFormatter1(22223) == "22223")

            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2("true") == "true")
            assert(Exercises.prettyBooleanFormatter2("false") == "false")
            assert(Exercises.prettyBooleanFormatter2(66232223) == "66232223")

            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3("true") == "true")
            assert(Exercises.prettyBooleanFormatter3("false") == "false")
            assert(Exercises.prettyBooleanFormatter3("adadsadsaf") == "adadsadsaf")
        }
        'test_max1 - {
            assert(Exercises.max1(Seq(1,2,3,4)) == 4)
            assert(Exercises.max1(Seq()) == -1)
        }
        'test_max2 - {
            assert(Exercises.max2(Seq(1,2,3)) == Seq(3))
            assert(Exercises.max2(Seq()) == Seq())
        }
        'test_sum - {
            assert(Exercises.sum1(1,2) == 3)
            assert(Exercises.sum2(1,2) == 3)
            assert(Exercises.sum3(1,2) == 3)
        }
    }
}
