package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatters - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(111) == "111")
            assert(Exercises.prettyBooleanFormatter1((222, "scala")) == "(222,scala)")

            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(111) == "111")
            assert(Exercises.prettyBooleanFormatter2((222, "scala")) == "(222,scala)")

            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(111) == "111")
            assert(Exercises.prettyBooleanFormatter3((222, "scala")) == "(222,scala)")
        }
        'test_getCollectionMaxValue - {
            assert(Exercises.max1(Seq(1, 2, 3, 2, 10)) == 10)
            intercept[IllegalArgumentException](Exercises.max1(Seq.empty[Int]))

            assert(Exercises.max2(Seq(1, 4, 3, 2, 1)) == Seq(4))
            assert(Exercises.max2(Seq.empty[Int]) == Seq.empty[Int])

            assert(Exercises.max3(Seq(7, 2, 5, 1, 0)) == Option(7))
            assert(Exercises.max3(Seq.empty[Int]).isEmpty)
        }
        'test_sumCollectionIntegers - {
            assert(Exercises.sum1(2, 7) == 9)
            assert(Exercises.sum1(0, 0) == 0)

            assert(Exercises.sum2(2, 7) == 9)
            assert(Exercises.sum2(0, 0) == 0)

            assert(Exercises.sum2(2, 7) == 9)
            assert(Exercises.sum2(0, 0) == 0)
        }
    }
}
