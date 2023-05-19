import scala.util.{Failure, Success, Try}

object Exercises {
  object Exercises {
    trait Read[T] {
      def read(str: String): Either[String, T]
    }
    object Read{
      def read[T](x: String)(implicit reader: Read[T]): Either[String, T] = reader.read(x)
    }

    implicit class ReadOps(value: String) {
      def read[V]()(implicit reader: Read[V]): Either[String, V] = reader.read(value)
    }

    implicit def readString: Read[String] = new Read[String] {
      override def read(value: String): Either[String, String] = Right(value)
    }

    def toInt(s: String): Try[Int] = Try(Integer.parseInt(s.trim))

    implicit def readInt: Read[Int] = new Read[Int] {
      override def read(x: String): Either[String, Int] = {
        toInt(x) match {
          case Success(x) => Right(x)
          case Failure(_) => Left(x)
        }
      }
    }

    val checkValueRegex = "Some\\((.+)\\)".r

    implicit def optionReader[T: Read]: Read[Option[T]] = new Read[Option[T]] {
      override def read(v: String): Either[String, Option[T]] = {
        v match {
          case "None" => Right(None)
          case _ => checkValueRegex.findFirstMatchIn(v) match {
            case Some(str) => Read.read[T](str.group(1)) match {
              case Right(x) => Right(Some(x))
              case Left(v) => Left(v)
            }
            case _ => Left(v)
          }
        }
      }
    }
  }
}