package homework_3

import utest._
object Test extends TestSuite{

    val tests = Tests{
        'test_first - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)

            assert(Exercises.prettyBooleanFormatter3("False") == "False")
            assert(Exercises.prettyBooleanFormatter3("false") == "false")
            assert(Exercises.prettyBooleanFormatter3("True") == "True")
            assert(Exercises.prettyBooleanFormatter3("true") == "true")
            assert(Exercises.prettyBooleanFormatter2("False") == "False")
            assert(Exercises.prettyBooleanFormatter2("false") == "false")
            assert(Exercises.prettyBooleanFormatter2("True") == "True")
            assert(Exercises.prettyBooleanFormatter2("true") == "true")
            assert(Exercises.prettyBooleanFormatter1("False") == "False")
            assert(Exercises.prettyBooleanFormatter1("false") == "false")
            assert(Exercises.prettyBooleanFormatter1("True") == "True")
            assert(Exercises.prettyBooleanFormatter1("true") == "true")

            assert(Exercises.prettyBooleanFormatter1("asd") == "asd")
            assert(Exercises.prettyBooleanFormatter2("asd") == "asd")
            assert(Exercises.prettyBooleanFormatter3("asd") == "asd")
            assert(Exercises.prettyBooleanFormatter1(1) == "1")
            assert(Exercises.prettyBooleanFormatter2(1) == "1")
            assert(Exercises.prettyBooleanFormatter3(1) == "1")
        }
        'testSecond -{
            assert((Exercises.max1(Seq(1,2,5,3)))==5)
            assert((Exercises.max2(Seq(1,2,5,3)))==Seq(5))
            assert(Exercises.max3(Seq(1, 2, 5, 3)).contains(5))

            val thrown = intercept[Exception] { Exercises.max1(Seq()) }
            assert(thrown.getMessage == "empty.max")

            assert(Exercises.max2(Seq())==Seq())
            assert(Exercises.max3(Seq()).isEmpty)
        }

        'testThird - {
            assert(Exercises.sum1(1,2)==3)
            assert(Exercises.sum2(1,2)==3)
            assert(Exercises.sum3(1,2)==3)
        }
    }
}
