package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'test_formatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1("строка") == "строка")
            assert(Exercises.prettyBooleanFormatter1(123) == "123")
        }
        'test_formatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2("строка") == "строка")
            assert(Exercises.prettyBooleanFormatter2(123) == "123")
        }
        'test_formatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3("строка") == "строка")
            assert(Exercises.prettyBooleanFormatter3(123) == "123")
        }
        'test_max1 - {
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Seq()) == -1)
            assert(Exercises.max1(Seq(5)) == 5)
        }
        'test_max1 - {
            assert(Exercises.max2(Seq(2, 1, 3)) == Seq(3))
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(5)) == Seq(5))
        }
        'test_max3 - {
            assert(Exercises.max3(Seq(2,1, 3)).contains(3))
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(5)).contains(5))
        }
        'test_sum1 - {
            assert(Exercises.sum1(3, 2) == 5)
            assert(Exercises.sum1(2, -7) == -5)
            assert(Exercises.sum1(0, 0) == 0)
        }
        'test_sum2 - {
            assert(Exercises.sum2(3, 2) == 5)
            assert(Exercises.sum2(2, -7) == -5)
            assert(Exercises.sum2(0, 0) == 0)
        }
        'test_sum3 - {
            assert(Exercises.sum3(3, 2) == 5)
            assert(Exercises.sum3(2, -7) == -5)
            assert(Exercises.sum3(0, 0) == 0)
        }
    }
}
