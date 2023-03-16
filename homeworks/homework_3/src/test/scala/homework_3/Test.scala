package homework_3

import homework_3.Exercises._
import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter - {
            val trueStr = "правда"
            assert(prettyBooleanFormatter1(true) == trueStr)
            assert(prettyBooleanFormatter2(true) == trueStr)
            assert(prettyBooleanFormatter3(true) == trueStr)

            val falseStr = "ложь"
            assert(prettyBooleanFormatter1(false) == falseStr)
            assert(prettyBooleanFormatter2(false) == falseStr)
            assert(prettyBooleanFormatter3(false) == falseStr)

            val char = "a"
            assert(prettyBooleanFormatter1('a') == char)
            assert(prettyBooleanFormatter2('a') == char)
            assert(prettyBooleanFormatter3('a') == char)

            val double = "3.14"
            assert(prettyBooleanFormatter1(3.14) == double)
            assert(prettyBooleanFormatter2(3.14) == double)
            assert(prettyBooleanFormatter3(3.14) == double)

            val int = "24"
            assert(prettyBooleanFormatter1(24) == int)
            assert(prettyBooleanFormatter2(24) == int)
            assert(prettyBooleanFormatter3(24) == int)
        }

        'test_max - {
            intercept[UnsupportedOperationException] {
                max1(Seq.empty)
            }
            assert(max1(Seq(1, 3, 4)) == 4)
            assert(max1(Seq(3, 3, 3)) == 3)
            assert(max2(Seq.empty) == Seq.empty)
            assert(max2(Seq(1, 3, 4)) == Seq(4))
            assert(max2(Seq(3, 3, 3)) == Seq(3))
            assert(max3(Seq.empty) == Option.empty)
            assert(max3(Seq(1, 3, 4)) == Option(4))
            assert(max3(Seq(3, 3, 3)) == Option(3))
        }

        'test_sum - {
            assert(sum1(5, 3) == 8)
            assert(sum1(0, 0) == 0)
            assert(sum1(-100, -50) == -150)
            assert(sum2(5, 3) == 8)
            assert(sum2(0, 0) == 0)
            assert(sum2(-100, -50) == -150)
            assert(sum3(5, 3) == 8)
            assert(sum3(0, 0) == 0)
            assert(sum3(-100, -50) == -150)

        }
    }
}
