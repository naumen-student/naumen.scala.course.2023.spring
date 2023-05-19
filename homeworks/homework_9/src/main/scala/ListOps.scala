import scala.annotation.tailrec
import DataList._

object ListOps {

  /**
   * Функция fold "сворачивает" список из Т в один элемент типа Т.
   * Если в списке лишь один элемент, то он и вернётся, два - вернётся результат применения f к этим элементам,
   * больше двух - результат применения к f(f(f(...), a[i - 1]), a[i])
   * @param f функция свёртывания. Применяется попарно к предыдущему результату применения и i-ому элементу списка
   * @return None - если список пустой
   */
  def foldOption[T](f: (T, T) => T): DataList[T] => Option[T] = {
    case EmptyList => None
    case NonEmptyList(head, EmptyList) => Some(head)
    case NonEmptyList(head, NonEmptyList(prevHead, prevTail)) => foldOption(f)(NonEmptyList(f(head, prevHead), prevTail))
  }

  /**
   * Используя foldOption[T](f: (T, T) => T) реализуйте суммирование всех элементов списка.
   * @return Если список пустой, то 0
   */
  def sum[T : Numeric](list: DataList[T]): T = {
    def sumT(a: T, b: T) = implicitly[Numeric[T]].plus(a, b)

    foldOption(sumT)(list).getOrElse(implicitly[Numeric[T]].zero)
  }

  /**
   * Фильтрация списка. Хвостовая рекурсия
   * @param f - фильтрующее правило (если f(a[i]) == true, то элемент остаётся в списке)
   */
  @tailrec
  private def filterImpl[T](f: T => Boolean)(buffer: DataList[T])(list: DataList[T]): DataList[T] = list match {
    case EmptyList => reverse(buffer)(EmptyList)
    case NonEmptyList(head, tail) if f(head) => filterImpl(f)(NonEmptyList(head, buffer))(tail)
    case NonEmptyList(head, tail) => filterImpl(f)(buffer)(tail)
  }

  @tailrec
  private def reverse[T](list: DataList[T])(buffer: DataList[T]): DataList[T] = list match {
    case EmptyList => buffer
    case NonEmptyList(head, tail) => reverse(tail)(NonEmptyList(head, buffer))
  }

  final def filter[T](f: T => Boolean): DataList[T] => DataList[T] = filterImpl(f)(EmptyList)

  final def map[A, B](f: A => B): DataList[A] => DataList[B] = {
    case EmptyList => EmptyList
    case NonEmptyList(head, tail) => NonEmptyList(f(head), map(f)(tail))
  }

  /**
   * Используя композицию функций реализуйте collect. Collect - комбинация filter и map.
   * В качестве фильтрующего правила нужно использовать f.isDefinedAt
   */
  def collect[A, B](f: PartialFunction[A, B]): DataList[A] => DataList[B] = 
    list => map(f)(filter(f.isDefinedAt)(list))
}