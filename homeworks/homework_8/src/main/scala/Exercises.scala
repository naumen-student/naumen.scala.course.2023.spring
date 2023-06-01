import scala.util.Try
object Exercises {
  trait Read[T] {
    def read(value: String): Either[String, T]
  }

  object Read {
    def read[T](string: String)(implicit readable: Read[T]): Either[String, T] = readable.read(string)
  }

  implicit class ReadableOps(string: String) {
    def read[T](implicit readable: Read[T]): Either[String, T] = try {
      readable.read(string)
    } catch {
      case e: Exception => Left(e.toString)
    }
  }

  implicit def stringRead: Read[String] = (string: String) => Right(string)

  implicit def intRead: Read[Int] = (string: String) => Right(string.toInt)

  implicit def optionRead[T: Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case string
      if string.startsWith("Some(") && string.endsWith(")") => string.slice(5, string.length - 1).read[T] match {
        case Left(_) => throw new IllegalArgumentException
        case Right(value) => Right(Some(value))
    }
    case _ => throw new IllegalArgumentException()
  }
}
