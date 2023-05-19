package homework_3

import utest._

object Test extends TestSuite{

    class CustomClass(index: Int, name: String) {
        override def toString: String = f"$index: $name"
    }

    def testPrettyBooleanFormatter(formatter: (Any) => String, argument: Any, expected: String): Unit = {
        val actual = formatter(argument)
        assert(expected == actual)
    }

    def testSum(summator: (Int, Int) => Int, arg1: Int, arg2: Int, expected: Int): Unit = {
        val actual = summator(arg1, arg2)
        assert(expected == actual)
    }

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1("true") == "true")
            assert(Exercises.prettyBooleanFormatter1(123) == "123")
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
        }
        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2("true") == "true")
            assert(Exercises.prettyBooleanFormatter2(123) == "123")
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
        }
        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3("true") == "true")
            assert(Exercises.prettyBooleanFormatter3(123) == "123")
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
        }
        'test_max1 - {
            intercept[IllegalArgumentException](Exercises.max1(Seq[Int]()))
            assert(Exercises.max1(Seq(1, 2, 3, 4)) == 4)
            assert(Exercises.max1(Seq(9, 8, 7, 6)) == 9)
            assert(Exercises.max1(Seq(4, 5, 6, 2, 1)) == 6)
        }
        'test_max2 - {
            assert(Exercises.max2(Seq[Int]()).length == 0)
            assert(Exercises.max2(Seq(1, 2, 3, 4))(0) == 4)
            assert(Exercises.max2(Seq(9, 8, 7, 6))(0) == 9)
            assert(Exercises.max2(Seq(4, 5, 6, 2, 1))(0) == 6)
        }
        'test_max3 - {
            assert(Exercises.max3(Seq[Int]()) == None)
            assert(Exercises.max3(Seq(1, 2, 3, 4)).contains(4))
            assert(Exercises.max3(Seq(9, 8, 7, 6)).contains(9))
            assert(Exercises.max3(Seq(4, 5, 6, 2, 1)).contains(6))
        }
        'test_sum1 - {
            assert(Exercises.sum1(2, 3) == 5)
            assert(Exercises.sum1(0, 7) == 7)
            assert(Exercises.sum1(-3, -2) == -5)
            assert(Exercises.sum1(-10, 12) == 2)
        }
        'test_sum2 - {
            assert(Exercises.sum1(2, 3) == 5)
            assert(Exercises.sum1(0, 7) == 7)
            assert(Exercises.sum1(-3, -2) == -5)
            assert(Exercises.sum1(-10, 12) == 2)
        }
        'test_sum3 - {
            assert(Exercises.sum1(2, 3) == 5)
            assert(Exercises.sum1(0, 7) == 7)
            assert(Exercises.sum1(-3, -2) == -5)
            assert(Exercises.sum1(-10, 12) == 2)
        }
    }
}
