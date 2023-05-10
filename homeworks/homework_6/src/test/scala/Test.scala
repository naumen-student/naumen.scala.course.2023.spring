import utest._


object Test extends TestSuite {

  val tests = Tests {
    'reverse - {
      assert(Exercises.reverse(Seq(0, 1, 2)) == Seq(2, 1, 0))
    }

    'fibonacci4Index - {
      assert(Exercises.fibonacci4Index(0) == 0)
      assert(Exercises.fibonacci4Index(1) == 1)
      assert(Exercises.fibonacci4Index(2) == 1)
      assert(Exercises.fibonacci4Index(4) == 3)
      assert(Exercises.fibonacci4Index(5) == 5)
      assert(Exercises.fibonacci4Index(10) == 55)
    }

    'fibonacci - {
      assert(Exercises.fibonacci(0) == Seq(0))
      assert(Exercises.fibonacci(1) == Seq(0, 1))
      assert(Exercises.fibonacci(2) == Seq(0, 1, 1))
      assert(Exercises.fibonacci(4) == Seq(0, 1, 1, 2, 3))
    }

    'morse - {
      assert(Exercises.morse("Friends") == "..-. .-. .. . -. -.. ...")
      assert(Exercises.morse("Friendly") == "..-. .-. .. . -. -.. .-.. -.--")
    }

    'wordReverse - {
      assert(Exercises.wordReverse("Друзья, давайте жить дружно!") == "Яьзурд, етйавад ьтиж онжурд!")
    }
  }
}
