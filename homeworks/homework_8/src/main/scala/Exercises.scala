import scala.util.{Failure, Success, Try}
object Exercises {
  trait Read[T] {
    def read(str: String) : Either[String, T]
  }

  object Read {
    def read[T](str: String)(implicit read: Read[T]): Either[String, T] = read.read(str)
  }

  implicit class ReadableOps(str: String) {
    def read[T](implicit read: Read[T]) : Either[String, T] = read.read(str)
  }

  implicit def strRead: Read[String] = (str: String) => Right(str)

  implicit def intRead: Read[Int] = (str: String) => Try(str.toInt) match {
    case Success(value) => Right(value)
    case Failure(exception) => Left(f"($str) is not int!")
  }

  private val regex = "Some\\((.*)\\)".r

  implicit def optionRead[T : Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case regex(inner) => inner.read[T] match {
      case Right(value) => Right(Some(value))
      case Left(exception) => Left(exception)
    }
    case str => Left(f"$str is not option!")
  }
}
