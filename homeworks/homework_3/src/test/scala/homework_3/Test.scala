package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1("правда") == trueStr)

            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(1) == "1")

            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(1) == "1")
        }
        'test_max - {
            assert(Exercises.max1(Seq(2, 6, 3, 4, 5)) == 6)
            assert(Exercises.max1(Seq(1, 2, 3, -4)) == 3)
            assert(Exercises.max1(Seq(8, 6, 3, 90, 21)) == 90)
            assert(Exercises.max1(null) == 0)


            assert(Exercises.max2(Seq(2, 6, 3, 4, 5)) == Seq(6))
            assert(Exercises.max2(Seq(1, 2, 3, -4)) == Seq(3))
            assert(Exercises.max2(Seq(8, 6, 3, 90, 21)) == Seq(90)) 
            assert(Exercises.max2(null) == Seq.empty)


            assert(Exercises.max3(Seq(2, 6, 3, 4, 5)) == Some(6))
            assert(Exercises.max3(Seq(1, 2, 3, -4)) == Some(3))
            assert(Exercises.max3(Seq(8, 6, 3, 90, 21)) == Some(90)) 
            assert(Exercises.max3(null) == None)
        }
        'test_sum - {
            assert(Exercises.sum1(3, 4) == 7)
            assert(Exercises.sum1(-1, 0) == -1)
            assert(Exercises.sum1(1000, -1000) == 0)

            assert(Exercises.sum2(3, 4) == 7)
            assert(Exercises.sum2(-1, 0) == -1)
            assert(Exercises.sum2(1000, -1000) == 0)

            assert(Exercises.sum3(3, 4) == 7)
            assert(Exercises.sum3(-1, 0) == -1)
            assert(Exercises.sum3(1000, -1000) == 0)
        }
    }
}
