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
    }
}
