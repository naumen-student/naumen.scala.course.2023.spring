package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'formatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1("") == "")
            assert(Exercises.prettyBooleanFormatter1("правда") == "правда")
            assert(Exercises.prettyBooleanFormatter1("ложь") == "ложь")
            assert(Exercises.prettyBooleanFormatter1(123) == "123")
        }
        'formatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2("") == "")
            assert(Exercises.prettyBooleanFormatter2("правда") == "правда")
            assert(Exercises.prettyBooleanFormatter2("ложь") == "ложь")
            assert(Exercises.prettyBooleanFormatter2(123) == "123")
        }
        'formatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3("") == "")
            assert(Exercises.prettyBooleanFormatter3("правда") == "правда")
            assert(Exercises.prettyBooleanFormatter3("ложь") == "ложь")
            assert(Exercises.prettyBooleanFormatter3(123) == "123")
        }

        'max1 - {
            assert(Exercises.max1(Seq()) == 0)
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(2,3,1)) == 3)
        }
        'max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(2, 3, 1)) == Seq(3))
        }
        'max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1)).get == 1)
            assert(Exercises.max3(Seq(2, 3, 1)).get == 3)
        }

        'sum1 - {
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-3, 5) == 2)
        }
        'sum2 - {
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(-3, 5) == 2)
        }
        'sum3 - {
            assert(Exercises.sum3(0, 0) == 0)
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum3(-3, 5) == 2)
        }
    }
}
