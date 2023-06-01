import scala.util.Try

object Exercises {
  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  object Read {
    def read[T](str: String)(implicit read: Read[T]): Either[String, T] =
      read.read(str)
  }

  implicit class RichReadableString(str: String) {
    def read[T](implicit read: Read[T]): Either[String, T] = Read.read[T](str)
  }

  implicit val stringRead: Read[String] = (str: String) => Right(str)

  implicit val intRead: Read[Int] = (str: String) =>
    Try(str.toInt).toEither.left.map(_ => s"Value $str is not Int")

  private val somePattern: Regex = "Some\\((.*)\\)".r

  implicit def optionRead[TIn](implicit
      inRead: Read[TIn]
  ): Read[Option[TIn]] = {
    case somePattern(in) =>
      Read
        .read[TIn](in)
        .left
        .map(e => s"Exception when reading a value inside Some: $e")
        .right
        .map(Some(_))
    case "None" => Right(None)
    case value  => Left(s"Value $value is not Option")
  }
}
