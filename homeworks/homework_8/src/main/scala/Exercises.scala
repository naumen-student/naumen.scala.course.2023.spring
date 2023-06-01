import scala.util.Try
object Exercises {
  trait Read[T] {
    def read(str: String) : Either[String, T]
  }

  object Read {
    def read[T](str: String)(implicit readable: Read[T]): Either[String, T] = readable.read(str)
  }

  implicit class ReadableOps(value: String) {
    def read[T](implicit readable: Read[T]) : Either[String, T] = try {
      readable.read(value)
    } catch {
      case e: Exception => Left(e.toString)
    }
  }

  implicit def strRead: Read[String] = (str: String) => Right(str)

  implicit def intRead: Read[Int] = (str: String) => Right(str.toInt)

  implicit def optionRead[T : Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case str if str.startsWith("Some(") && str.endsWith(")") => str.slice(5, str.length - 1).read[T] match {
      case Left(_) => throw new IllegalArgumentException
      case Right(value) => Right(Some(value))
    }
    case _ => throw new IllegalArgumentException()
  }
}
