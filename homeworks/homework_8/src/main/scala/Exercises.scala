import scala.util.matching.Regex

object Exercises {
  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  object Read {
    def read[T](str: String)(implicit read: Read[T]): Either[String, T] = {
      read.read(str)
    }

    implicit class ReadableString(str: String) {
      def read[T](implicit read: Read[T]): Either[String, T] = Read.read[T](str)
    }
  }

  implicit val stringRead: Read[String] = (str: String) => {
    Right(str)
  }

  implicit val intRead: Read[Int] = (str: String) => {
    try Right(str.toInt) catch {
      case _: NumberFormatException => Left(s"$str is not Int")
    }
  }

  private val some: Regex = {
    "Some\\((.*)\\)".r
  }

  implicit def optionRead[A](implicit reader: Read[A]): Read[Option[A]] = {
    case "None" => Right(None)
    case some(in) => reader.read(in) match {
      case Right(t) => Right(Some(t))
      case Left(err) => Left(err)
    }
    case str => Left(s"$str is not Option[A]")
  }
}