package homework_3

import utest._
import homework_3.Exercises._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            val trueStr = "правда"
            assert(prettyBooleanFormatter1(true) == trueStr)

            val falseStr = "ложь"
            assert(prettyBooleanFormatter1(false) == falseStr)

            val char = "c"
            assert(prettyBooleanFormatter1('c') == char)

            val double = "4.0123"
            assert(prettyBooleanFormatter1(4.0123) == double)
        }

        'test_prettyBooleanFormatter2 - {
            val trueStr = "правда"
            assert(prettyBooleanFormatter2(true) == trueStr)

            val falseStr = "ложь"
            assert(prettyBooleanFormatter2(false) == falseStr)

            val char = "c"
            assert(prettyBooleanFormatter2('c') == char)

            val double = "4.0123"
            assert(prettyBooleanFormatter2(4.0123) == double)
        }

        'test_prettyBooleanFormatter3 - {
            val trueStr = "правда"
            assert(prettyBooleanFormatter3(true) == trueStr)

            val falseStr = "ложь"
            assert(prettyBooleanFormatter3(false) == falseStr)

            val char = "c"
            assert(prettyBooleanFormatter3('c') == char)

            val double = "4.0123"
            assert(prettyBooleanFormatter3(4.0123) == double)
        }

        'test_max1 - {
            intercept[UnsupportedOperationException]{
                max1(Seq.empty)
            }
            assert(max1(Seq(1, 2, 3)) == 3)
            assert(max1(Seq(1, 1, 1)) == 1)
        }

        'test_max2 - {
            assert(max2(Seq.empty) == Seq.empty)
            assert(max2(Seq(1, 2, 3)) == Seq(3))
            assert(max2(Seq(1, 1, 1)) == Seq(1))
        }

        'test_max3 - {
            assert(max3(Seq.empty) == Option.empty)
            assert(max3(Seq(1, 2, 3)) == Option(3))
            assert(max3(Seq(1, 1, 1)) == Option(1))
        }

        'test_sum1 - {
            assert(sum1(1, 2) == 3)
            assert(sum1(0, 0) == 0)
            assert(sum1(-100, -100) == -200)
        }

        'test_sum2 - {
            assert(sum2(1, 2) == 3)
            assert(sum2(0, 0) == 0)
            assert(sum2(-100, -100) == -200)
        }

        'test_sum3 - {
            assert(sum3(1, 2) == 3)
            assert(sum3(0, 0) == 0)
            assert(sum3(-100, -100) == -200)
        }
    }
}
