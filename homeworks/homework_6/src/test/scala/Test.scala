import utest._


object Test extends TestSuite{

  val tests = Tests{
    'reverse - {
      assert(Exercises.reverse(Seq(1, 2, 3)) == Seq(3, 2, 1))
      assert(Exercises.reverse(Seq(-1, -2, -3)) == Seq(-3, -2, -1))
    }

    'fibonacci4Index - {
      assert(Exercises.fibonacci4Index(2) == 1)
      assert(Exercises.fibonacci4Index(5) == 5)
    }

    'fibonacci - {
      assert(Exercises.fibonacci(2) == Seq(0, 1, 1))
      assert(Exercises.fibonacci(5) == Seq(0, 1, 1, 2, 3, 5))
    }

    'morse - {
      assert(Exercises.morse("SOS") == "... --- ...")
      assert(Exercises.morse("Hello world!") == ".... . .-.. .-.. ---   .-- --- .-. .-.. -..!")
    }

    'wordReverse - {
      assert(Exercises.wordReverse("Зима!.. Крестьянин, торжествуя...") == "Амиз!.. Ниняьтсерк, яувтсежрот...")
    }


  }
}
