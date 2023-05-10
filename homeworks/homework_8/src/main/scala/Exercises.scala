import Exercises.Read.ReadOps


object Exercises {

    trait Read[T] {
        def read(s: String): Either[String, T]
    }

    object Read {
        def read[T](s: String)(implicit r: Read[T]): Either[String, T] = r.read(s)

        implicit class ReadOps(s: String) {
            def read[T](implicit r: Read[T]): Either[String, T] = r.read(s);
        }
    }

    implicit def stringRead: Read[String] = (s: String) => Right(s)


    implicit def intRead: Read[Int] = (s: String) => {
        try {
            Right(s.toInt)
        } catch {
            case _: NumberFormatException => Left("Unable to parse Int")
        }
    }

    private val pattern = "some(.*)".r

    implicit def optionRead[T](implicit r: Read[T]): Read[Option[T]] = (s: String) => s.trim.toLowerCase match {
        case "none" => Right(None)
        case pattern(other) => other.stripPrefix("(").stripSuffix(")").read[T].map(Some(_))
        case _ => Left("Unable parse Option")
    }
}
