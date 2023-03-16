package homework_3

import utest._

object Test extends TestSuite {
  val tests: Tests = Tests {
    "task 1" - {
      val oleg = new {val name = "Oleg"; val age = 20; override def toString: String = s"$name, $age yo"}
      val olegString = "Oleg, 20 yo"

      "instanceOf" - {
        "val"  - { Exercises.prettyBooleanFormatter1(1) ==> "1" }
        "ref"  - { Exercises.prettyBooleanFormatter1(oleg) ==> olegString }
        "bool" - { Exercises.prettyBooleanFormatter1(true) ==> "правда" }
        "null" - { intercept[NullPointerException] { Exercises.prettyBooleanFormatter1(null) } }
      }
      "matching" - {
        "val"  - { Exercises.prettyBooleanFormatter2(1) ==> "1" }
        "ref"  - { Exercises.prettyBooleanFormatter2(oleg) ==> olegString }
        "bool" - { Exercises.prettyBooleanFormatter2(true) ==> "правда" }
        "null" - { intercept[NullPointerException] { Exercises.prettyBooleanFormatter2(null) } }
      }
      "reflect" - {
        "val"  - { Exercises.prettyBooleanFormatter3(1) ==> "1" }
        "ref"  - { Exercises.prettyBooleanFormatter3(oleg) ==> olegString }
        "bool" - { Exercises.prettyBooleanFormatter3(true) ==> "правда" }
        "null" - { intercept[NullPointerException] { Exercises.prettyBooleanFormatter3(null) } }
      }
    }

    "task 2" - {
      "max1" - {
        "normal seq" - { assert(Exercises.max1(Seq(1, 2, 3, 4, 5)) == 5) }
        "empty seq"  - { intercept[IllegalArgumentException] { Exercises.max1(Seq()) } }
        "null"       - { intercept[NullPointerException] { Exercises.max1(null) } }
      }
      "max2" - {
        "normal seq" - { assert(Exercises.max2(Seq(1, 2, 3, 4, 5)) == Seq(5)) }
        "empty seq"  - { assert(Exercises.max2(Seq()) == Seq()) }
        "null"       - { intercept[NullPointerException] { Exercises.max2(null) } }
      }
      "max3" - {
        "normal seq" - { assert(Exercises.max3(Seq(1, 2, 3, 4, 5)) == Option(5)) }
        "empty seq"  - { assert(Exercises.max3(Seq()) == Option(null)) }
        "null"       - { intercept[NullPointerException] { Exercises.max3(null) } }
      }
    }

    "task 3" - {
      "sum1" - {
        "normal args"           - { assert(Exercises.sum1(2, 3) == 5) }
        "out of bounds"         - { assert(Exercises.sum1(Int.MaxValue, 1) == Int.MinValue) }
        "idk what to test here" - { assert(Exercises.sum1(1, 1) == 2) }
      }
      "sum2" - {
        "normal args"           - { assert(Exercises.sum2(2, 3) == 5) }
        "out of bounds"         - { assert(Exercises.sum2(Int.MaxValue, 1) == Int.MinValue) }
        "idk what to test here" - { assert(Exercises.sum2(1, 1) == 2) }
      }
      "sum3" - {
        "normal args"           - { assert(Exercises.sum3(2, 3) == 5) }
        "out of bounds"         - { assert(Exercises.sum3(Int.MaxValue, 1) == Int.MinValue) }
        "idk what to test here" - { assert(Exercises.sum3(1, 1) == 2) }
      }
    }
  }
}
