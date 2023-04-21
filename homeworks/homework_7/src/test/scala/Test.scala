import utest._

object Test extends TestSuite {
    val tupleMonad: Monad[Tuple1] = new Monad[Tuple1] {
        def pure[A](a: A): Tuple1[A] = Tuple1(a)

        def flatMap[A, B](fa: Tuple1[A])(f: A => Tuple1[B]): Tuple1[B] =
            f(fa._1)
    }

    val tests: Tests = Tests {
        'test_CombineTwoMonadic - {
            assert(tupleMonad.map2(Tuple1(1), Tuple1(2))((a, b) => a + b) == Tuple1(3))
        }
        'test_Sequence - {
            assert(tupleMonad.sequence(List(Tuple1(1), Tuple1(2), Tuple1(3))) == Tuple1(List(1,2,3)))
        }
        'test_Compose - {
            val f: Int => Tuple1[Double] = a => Tuple1(a / 2.0)
            val g: Double => Tuple1[String] = a => Tuple1(a.toString)
            assert(tupleMonad.compose(f)(g)(3) == Tuple1("1.5"))
        }
        'test_FunctorFromMonad - {
            val funcVal = Functor.functorFromMonad[Option](new Monad[Option] {
              def pure[A](a: A): Option[A] = Some(a)
              def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] =
                fa.flatMap(f)
            }).map[Int, String](Some(3))(_.toString)

            assert(funcVal.contains("3"))
        }
    }
}
