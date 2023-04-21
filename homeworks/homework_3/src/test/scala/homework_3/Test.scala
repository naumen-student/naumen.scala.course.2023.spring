package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        val trueStr = "true"
        val falseStr = "false"
        val numberStr = "101"


        'test_BooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(101) == numberStr)
        }

        'test_BooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(101) == numberStr)
        }

        'test_BooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(101) == numberStr)
        }

        'test_max1 - {
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Seq.empty) == 0)
            assert(Exercises.max1(Seq(3, 2, 1)) == 3)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3))
            assert(Exercises.max2(Seq.empty) == Seq.empty)
            assert(Exercises.max2(Seq(3, 2, 1)) == Seq(3))
        }

        'test_max3 - {
            assert(Exercises.max3(Seq(1, 2, 3)) == Option(3))
            assert(Exercises.max3(Seq.empty).isEmpty)
            assert(Exercises.max3(Seq(3, 2, 1)) == Option(3))
        }

        'test_sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(0, 99) == 99)
            assert(Exercises.sum1(99,0) == 99)
        }

        'test_sum2 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(0, 99) == 99)
            assert(Exercises.sum2(99,0) == 99)
        }

        'test_sum3 - {
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum3(0, 99) == 99)
            assert(Exercises.sum3(99,0) == 99)
        }
    }
}
