import utest._

object Test extends TestSuite{
    val tests = Tests{
        val trueStr = "правда"
        val falseStr = "ложь"
        'test_example - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(1) == "1")
            assert(Exercises.prettyBooleanFormatter1("1") == "1")
        }
        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(1) == "1")
            assert(Exercises.prettyBooleanFormatter2("1") == "1")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(1) == "1")
            assert(Exercises.prettyBooleanFormatter3("1") == "1")
        }

        'test_max1 - {
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(1, 3)) == 3)
            assert(Exercises.max1(Seq(3, 3, 7)) == 7)
            assert(Exercises.max1(Seq()) == -1)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(1, 3)) == Seq(3))
            assert(Exercises.max2(Seq(3, 3, 7)) == Seq(7))
            assert(Exercises.max2(Seq()) == Seq())
        }

        'test_max3 - {
            assert(Exercises.max3(Seq(1)).contains(1))
            assert(Exercises.max3(Seq(1, 3)).contains(3))
            assert(Exercises.max3(Seq(3, 3, 7)).contains(7))
            assert(Exercises.max3(Seq()).isEmpty)
        }

        'test_sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(1, -6) == -5)
            assert(Exercises.sum1(0, 0) == 0)
        }

        'test_sum2 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(1, -6) == -5)
            assert(Exercises.sum2(0, 0) == 0)
        }

        'test_sum3 - {
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum3(1, -6) == -5)
            assert(Exercises.sum3(0, 0) == 0)
        }
    }
}
