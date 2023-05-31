import scala.util.Try
import scala.util.matching.Regex

object Exercises {
  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  object Read {
    def read[T](str: String)(implicit read: Read[T]): Either[String, T] = read.read(str)
  }

  implicit class RichReadableString(str: String) {
    def read[T](implicit read: Read[T]): Either[String, T] = Read.read[T](str)
  }

  implicit val stringRead: Read[String] = new Read[String] {
    def read(str: String): Either[String, String] = Right(str)
  }

  implicit val intRead: Read[Int] = new Read[Int] {
    def read(str: String): Either[String, Int] = Try(str.toInt).toEither
      .left.map(_ => s"Value $str is not Int")
  }

  private val somePattern: Regex = "Some\\((.*)\\)".r

  implicit def optionRead[TIn](implicit inRead: Read[TIn]): Read[Option[TIn]] = new Read[Option[TIn]] {
    def read(str: String): Either[String, Option[TIn]] = str match {
      case somePattern(in) => Read.read[TIn](in)
        .left.map(e => s"Exception when reading a value inside Some: $e")
        .right.map(Some(_))
      case "None" => Right(None)
      case value => Left(s"Value $value is not Option")
    }
  }
}
