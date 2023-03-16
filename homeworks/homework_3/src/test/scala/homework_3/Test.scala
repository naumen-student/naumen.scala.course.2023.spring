package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'prettyBooleanFormattersTest - {
            val trueStr = "правда"
            val falseStr = "ложь"
            val num = 123
            val str = "I am string"

            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)

            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)

            assert(Exercises.prettyBooleanFormatter1(num) == "123")
            assert(Exercises.prettyBooleanFormatter2(num) == "123")
            assert(Exercises.prettyBooleanFormatter3(num) == "123")

            assert(Exercises.prettyBooleanFormatter1(str) == "I am string")
            assert(Exercises.prettyBooleanFormatter2(str) == "I am string")
            assert(Exercises.prettyBooleanFormatter3(str) == "I am string")
        }

        'maxTest - {
            val thrown = intercept[Exception] {
                Exercises.max1(Seq())
            }
            assert(thrown.getMessage == "Cannot find max value of empty sequence")
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max3(Seq()).isEmpty)

            assert(Exercises.max1(Seq(6, 14, 7, 25)) == 25)
            assert(Exercises.max2(Seq(6, 14, 7, 25)).head == 25)
            assert(Exercises.max3(Seq(6, 14, 7, 25)).get == 25)

            assert(Exercises.max1(Seq(5)) == 5)
            assert(Exercises.max2(Seq(5)).head == 5)
            assert(Exercises.max3(Seq(5)).get == 5)
        }

        'sumTest - {
            assert(Exercises.sum1(2, 2) == 4)
            assert(Exercises.sum2(2, 2) == 4)
            assert(Exercises.sum3(2, 2) == 4)

            assert(Exercises.sum1(-2, 4) == 2)
            assert(Exercises.sum2(-2, 4) == 2)
            assert(Exercises.sum3(-2, 4) == 2)

            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum3(0, 0) == 0)
        }
    }
}