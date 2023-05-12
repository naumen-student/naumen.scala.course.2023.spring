import scala.util.Try
import scala.util.Success
import scala.util.Failure
import scala.util.matching.Regex
object Exercises {
  private val someRegex = """^Some\((.*)\)$""".r
  trait Read[T] {
    def read(value: String): Either[String, T]
  }
  object Read {
    def read[T](value: String)(implicit readable: Read[T]): Either[String, T] = readable.read(value)
  }
  implicit def stringRead: Read[String] = (value: String) => Right(value)
  implicit def intRead: Read[Int] = (value: String) => Try(value.toInt) match {
    case Success(value) => Right(value)
    case Failure(_) => Left(s"Unable to convert '$value' to integer")
  }
  implicit def optionRead[T: Read]: Read[Option[T]] = (value: String) => value match {
    case "None" => Right(None)
    case someRegex(argument) => argument.read[T].right.map(Some(_))
    case _ => Left(s"Unable to convert '$value' to Option")
  }
  implicit class ReadableOps(value: String) {
    def read[T](implicit readable: Read[T]): Either[String, T] = readable.read(value)
  }
}
