import scala.util.Try
object Exercises {
  trait Read[T] {
    def read(str: String): Either[String, T]
  }

  object Read {
    def read[T](value: String)(implicit r: Read[T]): Either[String, T] = r.read(value)
  }

  implicit class ReadOps(s: String) {
    def read[T](implicit r: Read[T]): Either[String, T] = r.read(s)
  }

  implicit def stringRead: Read[String] = (str: String) => {
    Right(str)
  }

  implicit def intRead: Read[Int] = (value: String) => {
    try {
      Right(value.toInt)
    } catch {
      case _: Throwable => Left("Unable to convert value to Int")
    }
  }

  private val pattern = """^Some\((.*)\)$""".r

  implicit def optionRead[T: Read]: Read[Option[T]] = (value: String) => value match {
    case "None" => Right(None)
    case pattern(arg) => arg.read[T].right.map(Some(_))
    case _ => Left(s"Unable to convert value to Option")
  }
}
