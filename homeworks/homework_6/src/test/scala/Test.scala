import utest._


object Test extends TestSuite {

    val tests = Tests {
        'reverse - {
            assert(Exercises.reverse(Seq(1, 2, 3)) == Seq(3, 2, 1))
            assert(Exercises.reverse(Seq(-1, -2, -3)) == Seq(-3, -2, -1))
        }

        'fibonacci4Index - {
            assert(Exercises.fibonacci4Index(2) == 1)
            assert(Exercises.fibonacci4Index(5) == 5)
            assert(Exercises.fibonacci4Index(6) == 8)
            assert(Exercises.fibonacci4Index(7) == 13)
            assert(Exercises.fibonacci4Index(8) == 21)
            assert(Exercises.fibonacci4Index(9) == 34)
            assert(Exercises.fibonacci4Index(10) == 55)
            assert(Exercises.fibonacci4Index(11) == 89)
            assert(Exercises.fibonacci4Index(22) == 17711)

        }

        'fibonacci - {
            assert(Exercises.fibonacci(2) == Seq(0, 1, 1))
            assert(Exercises.fibonacci(5) == Seq(0, 1, 1, 2, 3, 5))
            assert(Exercises.fibonacci(22) == Seq(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711))
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
