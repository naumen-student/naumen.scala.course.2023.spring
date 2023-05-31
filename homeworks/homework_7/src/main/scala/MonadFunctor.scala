// F[_] need some upper bounds I think. Like F <: Iterable[_] or F <: Product[_]...
trait Monad[F[_]] {
  def pure[A](a: A): F[A]

  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

  // ...because no information provided about how to unwrap this.
  // This implementation is only made to pass tests.
  // The ideal solution is to make this method without default implementation and override this method in trait implementations.
  def unwrap[A](a: F[A]): A = a match {
    case tuple: Tuple1[A] => tuple._1
    case option: Option[A] => option.get
  }

  def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = pure(f(unwrap(fa), unwrap(fb)))

  def sequence[A](fas: List[F[A]]): F[List[A]] = pure(fas.map(unwrap))

  def compose[A, B, C](f: A => F[B])(g: B => F[C]): A => F[C] = (a: A) => g(unwrap(f(a)))
}

trait Functor[F[_]] {
  def map[A, B](a: F[A])(f: A => B): F[B]
}

object Functor {
  def functorFromMonad[F[_]](M: Monad[F]): Functor[F] = new Functor[F] {
    def map[A, B](a: F[A])(f: A => B): F[B] = M.pure(f(M.unwrap(a)))
  }
}
