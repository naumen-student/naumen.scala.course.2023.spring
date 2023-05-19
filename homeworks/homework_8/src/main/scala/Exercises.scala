import scala.util.{Failure, Success, Try}
import scala.util.matching.Regex

object Exercises {
  trait Read[T] {
    def read(s: String): Either[String, T]
  }

  implicit class ReadImplicit(s: String) {
    def read[T]()(implicit read: Read[T]): Either[String, T] = read.read(s);
  }

  object Read {
    def read[T](s: String)(implicit read: Read[T]): Either[String, T] = read.read(s);

    implicit object ReadString extends Read[String] {
      def read(s: String): Either[String, String] = Right(s);
    }

    implicit object ReadInt extends Read[Int] {
      def read(s: String): Either[String, Int] = {
        Try(s.toInt) match {
          case Success(i) => Right(i)
          case Failure(e) => Left(e.getMessage)
        }
      }
    }

    val some: Regex = """Some\((\S+)\)""".r
    val error = "Impossible to read";

    implicit def ReadOption[T: Read]: Read[Option[T]] = {
      case "None" => Right(None)
      case some(value) => value.read[T] match {
        case Right(x) => Right(Some(x))
        case Left(x) => Left(error)
      }
      case _ => Left(error)
    }
  }
}
