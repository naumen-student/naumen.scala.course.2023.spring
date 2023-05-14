sealed trait DataList[+T]

object DataList {
  final case class NonEmptyList[+T](head: T, tail: DataList[T]) extends DataList[T]
  case object EmptyList extends DataList[Nothing]

  def apply[T](x: T*): DataList[T] = x.toList match {
    case head :: tail => NonEmptyList(head, apply(tail: _*))
    case _ => EmptyList
  }
}
