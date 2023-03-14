package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 - testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1)
        'test_prettyBooleanFormatter2 - testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter2)
        'test_prettyBooleanFormatter3 - testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter3)
        'test_max1 - {
            intercept[IllegalArgumentException](Exercises.max1(Seq.empty[Int]))

            testFindMax[Int](Exercises.max1, Int.box)
        }
        'test_max2 - {
            assert(Exercises.max2(Seq.empty[Int]).isEmpty)

            testFindMax[Seq[Int]](Exercises.max2, x => Seq(x))
        }
        'test_max3 - {
            assert(!Exercises.max3(Seq.empty[Int]).isDefined)

            testFindMax[Option[Int]](Exercises.max3, x => Some(x))
        }
        'test_sum1 - testSum(Exercises.sum1)
        'test_sum2 - testSum(Exercises.sum2)
        'test_sum3 - testSum(Exercises.sum3)
    }

    private def testPrettyBooleanFormatter(formatter: (Any) => String): Unit = {
        assert(formatter(true) == "правда")
        assert(formatter(false) == "ложь")
        assert(formatter(123) == "123")
        assert(formatter("123") == "123")
    }

    private def testFindMax[T](func: (Seq[Int]) => T, createExpected: (Int) => T): Unit = {
        assert(func(Seq(0)) == createExpected(0))
        assert(func(Seq(-10)) == createExpected(-10))
        assert(func(Seq(10)) == createExpected(10))
        assert(func(Seq(1, 1)) == createExpected(1))
        assert(func(Seq(0, 0)) == createExpected(0))
        assert(func(Seq(-1, -1)) == createExpected(-1))
        assert(func(Seq(8, 0, 1, 10, 3, 2)) == createExpected(10))
        assert(func(Seq(-8, 0, -1, -10, -3, -2)) == createExpected(0))
        assert(func(Seq(-8, -1, -10, -3, -2)) == createExpected(-1))
    }

    private def testSum(func: (Int, Int) => Int): Unit = {
        assert(func(0, 0) == 0)
        assert(func(2, 2) == 4)
        assert(func(-2, -2) == -4)
        assert(func(10, -2) == 8)
        assert(func(-10, 8) == -2)
        assert(func(-5, -10) == -15)
        assert(func(5, 10) == 15)
    }
}
