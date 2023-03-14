package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter - {
            val trueStr1 = "правда"
            val trueStr2 = "ложь"
            val trueStr3 = "Some word"

            assert(Exercises.prettyBooleanFormatter1(true) == trueStr1)
            assert(Exercises.prettyBooleanFormatter1(false) == trueStr2)
            assert(Exercises.prettyBooleanFormatter1("Some word") == trueStr3)

            assert(Exercises.prettyBooleanFormatter2(true) == trueStr1)
            assert(Exercises.prettyBooleanFormatter2(false) == trueStr2)
            assert(Exercises.prettyBooleanFormatter2("Some word") == trueStr3)

            assert(Exercises.prettyBooleanFormatter3(true) == trueStr1)
            assert(Exercises.prettyBooleanFormatter3(false) == trueStr2)
            assert(Exercises.prettyBooleanFormatter3("Some word") == trueStr3)
        }

        'test_max - {
            val seq1 = Seq()
            val seq2 = Seq(-1, -3, -4, -5)
            val seq3 = Seq(2, -2, 0, 3)

            assert(Exercises.max1(seq1) == Seq().hashCode())
            assert(Exercises.max1(seq2) == -1)
            assert(Exercises.max1(seq3) == 3)

            assert(Exercises.max2(seq1) == Seq())
            assert(Exercises.max2(seq2) == Seq(-1))
            assert(Exercises.max2(seq3) == Seq(3))

            assert(Exercises.max3(seq1).isEmpty)
            assert(Exercises.max3(seq2).contains(-1))
            assert(Exercises.max3(seq3).contains(3))
        }

        'test_sum - {

            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(3, 4) == 7)
            assert(Exercises.sum1(5, 6) == 11)

            assert(Exercises.sum2(7, 8) == 15)
            assert(Exercises.sum2(9, 10) == 19)
            assert(Exercises.sum2(11, 12) == 23)

            assert(Exercises.sum3(13, 14) == 27)
            assert(Exercises.sum3(15, 16) == 31)
            assert(Exercises.sum3(17, 18) == 35)
        }
    }
}
