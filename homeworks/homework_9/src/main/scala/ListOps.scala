import DataList._
import scala.annotation.tailrec

object ListOps {

  def foldOption[T](f: (T, T) => T): DataList[T] => Option[T] = {
    case EmptyList => None
    case NonEmptyList(head, EmptyList) => Some(head)
    case NonEmptyList(head, NonEmptyList(tailHead, tail)) => foldOption(f)(NonEmptyList(f(head, tailHead), tail))
  }

  def sum[T: Numeric](list: DataList[T]): T = {
    def sumT(a: T, b: T) = implicitly[Numeric[T]].plus(a, b)
    foldOption(sumT)(list).getOrElse(implicitly[Numeric[T]].zero)
  }

  @tailrec
  private def filterImpl[T](f: T => Boolean)(buffer: DataList[T])(l: DataList[T]): DataList[T] = l match {
    case NonEmptyList(head, tail) => filterImpl(f)(if (f(head)) NonEmptyList(head, buffer) else buffer)(tail)
    case EmptyList => reverse(EmptyList)(buffer)
  }

  final def filter[T](f: T => Boolean): DataList[T] => DataList[T] = filterImpl(f)(EmptyList)

  final def map[A, B](f: A => B): DataList[A] => DataList[B] = {
    case EmptyList => EmptyList
    case NonEmptyList(head, tail) => NonEmptyList(f(head), map(f)(tail))
  }

  def collect[A, B](f: PartialFunction[A, B]): DataList[A] => DataList[B] =
    list => map(f)(filter(f.isDefinedAt)(list))

  @tailrec
  private def reverse[T](buffer: DataList[T])(l: DataList[T]): DataList[T] = l match {
    case NonEmptyList(head, tail) => reverse(NonEmptyList(head, buffer))(tail)
    case EmptyList => buffer
  }
}
