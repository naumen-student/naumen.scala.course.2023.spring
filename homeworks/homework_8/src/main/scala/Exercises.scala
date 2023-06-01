import scala.util.Try
import scala.util.Success
import scala.util.Failure

object Exercises {
  private val someRegex = """^Some\((.*)\)$""".r

  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  object Read {
    def read[T](str: String)(implicit readable: Read[T]): Either[String, T] = readable.read(str)
  }

  implicit class Readable(str: String) {
    def read[T](implicit readable: Read[T]): Either[String, T] = readable.read(str)
  }

  implicit def readStr: Read[String] = (str: String) => Right(str)

  implicit def readInt: Read[Int] = (str: String) => Try(str.toInt) match {
    case Success(result) => Right(result)
    case Failure(exception) => Left(exception.getMessage)
  }

  implicit def readOption[T: Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case someRegex(str) => str.read[T]
      .left.map(exception => exception)
      .right.map(x => Some(x))
    case _ => Left("Failed to read")
  }
}