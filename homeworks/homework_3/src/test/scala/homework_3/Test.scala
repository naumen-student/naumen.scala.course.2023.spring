package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(42) == "42")
            assert(Exercises.prettyBooleanFormatter1("string") == "string")
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(42) == "42")
            assert(Exercises.prettyBooleanFormatter2("string") == "string")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(42) == "42")
            assert(Exercises.prettyBooleanFormatter3("string") == "string")
        }

        'test_max1 - {
            assert(Exercises.max1(Seq(5, 10, 15)) == 15)
            assert(Exercises.max1(Seq()) == 0)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq(5, 10, 15)) == Seq(15))
            assert(Exercises.max2(Seq()) == Seq())
        }

        'test_max3 - {
            assert(Exercises.max3(Seq(5, 10, 15)) == Option(15))
            assert(Exercises.max3(Seq()).isEmpty)
        }

        'test_sum1 - {
            assert(Exercises.sum1(55, 100) == 155)
        }

        'test_sum2 - {
            assert(Exercises.sum2(55, 100) == 155)
        }

        'test_sum3 - {
            assert(Exercises.sum3(55, 100) == 155)
        }
    }
}
