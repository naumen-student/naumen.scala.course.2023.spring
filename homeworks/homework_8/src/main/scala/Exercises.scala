import scala.util.Try

object Exercises {

  private val regex = "Some\\((.*)\\)".r
  private val NONE = "None"

  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  object Read {
    def read[T](str: String)(implicit read: Read[T]): Either[String, T] = read.read(str)
  }

  implicit class RichReadableString(str: String) {
    def read[T](implicit read: Read[T]): Either[String, T] = Read.read[T](str)
  }

  implicit val stringRead: Read[String] = (str: String) => Right(str)

  implicit val intRead: Read[Int] = (s: String) => Try(s.toInt).toEither
    .left.map(_ => s"$s is not Int")

  implicit def optionRead[TIn](implicit inRead: Read[TIn]): Read[Option[TIn]] = {
    case regex(in) => Read.read[TIn](in)
      .left.map(e => s"Exception when reading a value from Some: $e")
      .right.map(Some(_))
    case NONE => Right(None)
    case value => Left(s"$value is not Option")
  }
}
