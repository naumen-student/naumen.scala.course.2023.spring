import scala.util.Try
import scala.util.{Failure, Success, Try}
object Exercises {
  trait Read[T] {
    def read(value: String): Either[String, T]
  }

  object Read {
    def read[T](value: String)(implicit readable: Read[T]): Either[String, T] = readable.read(value)
  }

  implicit def stringRead: Read[String] = (value: String) => Right(value)

  implicit def intRead: Read[Int] = (value: String) => Try(value.toInt) match {
    case Success(value) => Right(value)
    case Failure(_) => Left(s"Unable to convert '$value' to int")
  }

  implicit def optionRead[T: Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case arg => arg.read[T].right.map(Some(_))
    case value => Left(s"Unable to convert '$value' to Option")
  }

  implicit class ReadableOps(value: String) {
    def read[T](implicit readable: Read[T]): Either[String, T] = readable.read(value)
  }
}
