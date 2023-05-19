package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(12, true, "Hello") == "(12,true,Hello)")
        }
        'prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(12, true, "Hello") == "(12,true,Hello)")
        }
        'prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(12, true, "Hello") == "(12,true,Hello)")
        }
        'max1 - {
            assert(Exercises.max1(Seq(1,89,874,32)) == 874)
            assert(Exercises.max1(Seq()) == 0)
        }
        'max2 - {
            assert(Exercises.max2(Seq()) == List())
            assert(Exercises.max2(Seq(1,89,874,32)) == List(874))
        }
        'max3 - {
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max3(Seq(1, 89, 874, 32)) == Option(874))
        }
        'sum1 - {
            assert(Exercises.sum1(8, 9) == 17)
            assert(Exercises.sum1(1, 3) == 4)
            assert(Exercises.sum1(0, 1) == 1)
        }
        'sum2 - {
            assert(Exercises.sum2(8, 9) == 17)
            assert(Exercises.sum2(1, 3) == 4)
            assert(Exercises.sum2(0, 1) == 1)
        }
        'sum3 - {
            assert(Exercises.sum3(8, 9) == 17)
            assert(Exercises.sum3(1, 3) == 4)
            assert(Exercises.sum3(0, 1) == 1)
        }
    }
}
