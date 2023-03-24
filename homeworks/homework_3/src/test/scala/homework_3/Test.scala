package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'task_1 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(1) == "1")

            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(1) == "1")

            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(1) == "1")
        }
        'task_2 - {
            assert(Exercises.max1(Seq(2, 6, 9, 1, 3)) == 9)
            assert(Exercises.max1(Seq(1, 1, 3, -6)) == 3)
            assert(Exercises.max1(Seq(5, 14, 53, 44, 21)) == 53)
            assert(Exercises.max1(null) == 0)

            assert(Exercises.max2(Seq(2, 6, 9, 1, 3)) == Seq(9))
            assert(Exercises.max2(Seq(1, 1, 3, -6)) == Seq(3))
            assert(Exercises.max2(Seq(5, 14, 53, 44, 21)) == Seq(53))
            assert(Exercises.max2(null) == Seq.empty)

            assert(Exercises.max3(Seq(2, 6, 9, 1, 3)) == Some(9))
            assert(Exercises.max3(Seq(1, 1, 3, -6)) == Some(3))
            assert(Exercises.max3(Seq(5, 14, 53, 44, 21)) == Some(53))
            assert(Exercises.max3(null) == None)
        }
        'task_3 - {
            assert(Exercises.sum1(5, 8) == 13)
            assert(Exercises.sum1(-5, 0) == -5)
            assert(Exercises.sum1(1, -1) == 0)

            assert(Exercises.sum2(5, 8) == 13)
            assert(Exercises.sum2(-5, 0) == -5)
            assert(Exercises.sum2(1, -1) == 0)

            assert(Exercises.sum3(5, 8) == 13)
            assert(Exercises.sum3(-5, 0) == -5)
            assert(Exercises.sum3(1, -1) == 0)
        }
    }
}
