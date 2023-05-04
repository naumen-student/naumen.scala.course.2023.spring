
trait Monad[F[_]] {

    def unwrap[A](a: F[A]): A = a match {
        case tuple: Tuple1[A] => tuple._1
        case option: Option[A] => option.get
    }

    def pure[A](a: A): F[A]

    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

    def map2[A, B, C](fa: F[A], fb: F[B])(f: (B, A) => C): F[C] = {
        pure(f(unwrap(fb), unwrap(fa)))
    }

    def sequence[A](fas: List[F[A]]): F[List[A]] = {
        pure(fas.map(unwrap))
    }

    def compose[A, B, C](f: A => F[B])(g: B => F[C]): A => F[C] = {
        (a: A) => g(unwrap(f(a)))
    }
}

trait Functor[F[_]] {
    def map[A, B](a: F[A])(f: A => B): F[B]
}

object Functor {
    def functorFromMonad[F[_]](M: Monad[F]): Functor[F] = new Functor[F] {
        def map[A, B](a: F[A])(f: A => B): F[B] = {
            M.pure(f(M.unwrap(a)))
        }
    }
}
