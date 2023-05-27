package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1("правда") == "правда")
            assert(Exercises.prettyBooleanFormatter1(1213) == "1213")
        }
        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2("правда") == "правда")
            assert(Exercises.prettyBooleanFormatter2(1213) == "1213")
        }
        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3("правда") == "правда")
            assert(Exercises.prettyBooleanFormatter3(1213) == "1213")
        }
        'test_max1 - {
            assert(Exercises.max1(Seq(1, 3, 4, 6, 0, 5, 2)) == 6)
            assert(Exercises.max1(Seq(-1, -3, -4, -6, -5, -2)) == -1)
            assert(Exercises.max1(Seq(1, 1, 1, 2, 2, 2)) == 2)
            assert(Exercises.max1(Seq()) == 0)
        }
        'test_max2 - {
            assert(Exercises.max2(Seq(1, 3, 4, 6, 0, 5, 2)) == Seq(6))
            assert(Exercises.max2(Seq(-1, -3, -4, -6, -5, -2)) == Seq(-1))
            assert(Exercises.max2(Seq(1, 1, 1, 2, 2, 2)) == Seq(2))
            assert(Exercises.max2(Seq()) == Seq())
        }
        'test_max3 - {
            assert(Exercises.max3(Seq(1, 3, 4, 6, 0, 5, 2)) == Some(6))
            assert(Exercises.max3(Seq(-1, -3, -4, -6, -5, -2)) == Some(-1))
            assert(Exercises.max3(Seq(1, 1, 1, 2, 2, 2)) == Some(2))
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max3(Seq(1, 3, 4, 6, 0, 5, 2)) == Option(6))
            assert(Exercises.max3(Seq(-1, -3, -4, -6, -5, -2)) == Option(-1))
            assert(Exercises.max3(Seq(1, 1, 1, 2, 2, 2)) == Option(2))
        }
        'test_sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(0, 2) == 2)
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(-2, 0) == -2)
            assert(Exercises.sum1(-3, -4) == -7)
        }
        'test_sum2 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(0, 2) == 2)
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum2(-2, 0) == -2)
            assert(Exercises.sum2(-3, -4) == -7)
        }
        'test_sum3 - {
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum3(0, 2) == 2)
            assert(Exercises.sum3(0, 0) == 0)
            assert(Exercises.sum3(-2, 0) == -2)
            assert(Exercises.sum3(-3, -4) == -7)
        }
    }
}
