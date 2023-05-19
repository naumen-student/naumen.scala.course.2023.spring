import scala.util.{Try, Success, Failure}

object Exercises {
  trait Read[T] {
    def read(s: String): Either[String, T]
  }

  object Read {
    def read[T](s: String)(implicit read: Read[T]): Either[String, T] = read.read(s)
  }

  implicit class ReadableOps(s: String) {
    def read[T](implicit read: Read[T]): Either[String, T] = read.read(s)
  }

  implicit def stringRead: Read[String] = (s: String) => Right(s)

  implicit def intRead: Read[Int] = (s: String) => Try(s.toInt) match {
    case Success(value) => Right(value)
    case Failure(e) => Left(s"Exception: $e")
  }

  private val regex = "Some\\((.*)\\)".r

  implicit def optionRead[T: Read]: Read[Option[T]] = {
    case regex(in) => in.read[T] match {
      case Right(value) => Right(Some(value))
      case Left(e) => Left(e)
    }
    case "None" => Right(None)
    case value => Left(s"$value is not Option")
  }
}