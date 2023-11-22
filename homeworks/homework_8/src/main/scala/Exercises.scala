import scala.util.Try
import scala.util.matching.Regex
import scala.util.{Failure, Success, Try}

object Exercises {
  val regex: Regex = """Some\((.*)\)""".r

  trait Read[T] {
    def read(input: String): Either[String, T]
  }

  object Read {
    def read[T](input: String)(implicit read: Read[T]): Either[String, T] = read.read(input)
  }

  implicit class ExpressionReader(input: String) {
    def read[T](implicit read: Read[T]): Either[String, T] = Read.read[T](input)
  }

  implicit val readString: Read[String] = (input: String) => Right(input)

  implicit val readInt: Read[Int] = (input: String) => Try(input.toInt) match {
    case Success(value) => Right(value)
    case Failure(e) => Left(s"Exception: $e")
  }

  implicit def readOption[T: Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case regex(arg) => arg.read[T].right.map(Some(_))
    case value => Left(s"Unable to convert '$value' to Option")
  }
}
