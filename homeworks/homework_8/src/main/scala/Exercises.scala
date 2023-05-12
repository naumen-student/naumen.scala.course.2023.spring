import scala.util.{Failure, Success, Try}

object Exercises {
  private val pattern = "some(.*)".r

  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  object Read {
    def read[T](str: String)(implicit reader: Read[T]): Either[String, T] = reader.read(str)
  }

  implicit class ReadOps(s: String) {
    def read[T](implicit reader: Read[T]): Either[String, T] = reader.read(s)
  }

  implicit def stringRead: Read[String] = (str: String) => Right(str)

  implicit def intRead: Read[Int] = (str: String) => Try(str.toInt) match {
    case Success(str) => Right(str)
    case Failure(str) => Left(s"Failed to convert string ''$str'' to int")
  }

  implicit def optionRead[T](implicit reader: Read[T]): Read[Option[T]] = (str: String) => str.trim.toLowerCase() match {
    case pattern(other) => other.stripPrefix("(").stripSuffix(")").read[T].map(Some(_))
    case "none" => Right(None)
    case _ => Left(s"Failed to convert string ''$str'' to option")
  }
}
