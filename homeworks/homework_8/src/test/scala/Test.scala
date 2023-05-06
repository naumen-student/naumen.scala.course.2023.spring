import utest._

import Exercises._

object Test extends TestSuite {

  val tests = Tests {
    'string - {
      val success = Read.read[String]("test")
      assert(success == Right("test"))
    }

    'int - {
      val success = "123".read[Int]
      assert(success == Right(123))
      val failure = "test".read[Int]
      assert(failure.isLeft)
    }

    'option - {
      val none1 = "None".read[Option[String]]
      assert(none1 == Right(None))
      val someString = "Some(test)".read[Option[String]]
      assert(someString == Right(Some("test")))

      val none2 = "None".read[Option[Int]]
      assert(none2 == Right(None))
      val someInt = "Some(123)".read[Option[Int]]
      assert(someInt == Right(Some(123)))

      val failure = "test".read[Option[String]]
      assert(failure.isLeft)
      val someFailure = "Some(test)".read[Option[Int]]
      assert(someFailure.isLeft)

      val multipleSome =
        "Some(Some(Some(Some(123))))".read[Option[Option[Option[Option[Int]]]]]
      assert(multipleSome == Right(Some(Some(Some(Some(123))))))
      val multipleNone = "Some(Some(None))".read[Option[Option[Option[String]]]]
      assert(multipleNone == Right(Some(Some(None))))
      val lessNone = "Some(None)".read[Option[Option[Option[Int]]]]
      assert(lessNone == Right(Some(None)))
    }
  }
}
