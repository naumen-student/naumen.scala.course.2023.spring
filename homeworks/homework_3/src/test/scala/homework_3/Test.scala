package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test1 - {
            assert(Exercises.prettyBooleanFormatter1(true)=="правда")
            assert(Exercises.prettyBooleanFormatter1(false)=="ложь")
            assert(Exercises.prettyBooleanFormatter1(1)=="1")

            assert(Exercises.prettyBooleanFormatter2(true)=="правда")
            assert(Exercises.prettyBooleanFormatter2(false)=="ложь")
            assert(Exercises.prettyBooleanFormatter2(2)=="2")

            assert(Exercises.prettyBooleanFormatter3(true)=="правда")
            assert(Exercises.prettyBooleanFormatter3(false)=="ложь")
            assert(Exercises.prettyBooleanFormatter3(3)=="3")
        }
        'test2 -{
            intercept[NullPointerException] { Exercises.max1(Seq()) }
            assert(Exercises.max1(Seq(4,7,2,3))==7)

            assert(Exercises.max2(Seq())==Seq())
            assert(Exercises.max2(Seq(4,7,2,3))==Seq(7))

            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max2(Seq(4,7,2,3)).contains(7))
        }
        'test3 - {
            assert(Exercises.sum1(2,3)==5)
            assert(Exercises.sum2(2,3)==5)
            assert(Exercises.sum3(2,3)==5)
        }
    }
}
