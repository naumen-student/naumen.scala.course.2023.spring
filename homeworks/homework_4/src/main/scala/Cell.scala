import scala.collection.mutable

abstract class Cell[T]() {
  var value: Option[T]
}

class EmptyCell extends Cell[Nothing] {
  override var value: Option[Nothing] = None
  override def toString(): String = "empty"
}

class NumberCell(i: Int) extends Cell[Int] {
  override var value: Option[Int] = Some(i)
  override def toString(): String = i.toString
}

class StringCell(s: String) extends Cell[String] {
  override var value: Option[String] = Some(s)
  override def toString(): String = s
}

class Reference(
    val ix: Int,
    val iy: Int,
    val table: Table
) {
  override def equals(x: Any): Boolean =
    x.isInstanceOf[Reference] && x.asInstanceOf[Reference].ix == ix && x
      .asInstanceOf[Reference]
      .iy == iy && x.asInstanceOf[Reference].table == table
}
class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell[Reference] {
  override var value: Option[Reference] = Some(new Reference(ix, iy, table))
  override def toString(): String = {
    val (ix, iy, table) = (value.get.ix, value.get.iy, value.get.table)

    if (!table.containsCell(ix, iy))
      return "outOfRange"

    if (detectCyclic())
      return "cyclic"

    return table.getCell(ix, iy).get.toString()
  }

  private def detectCyclic(): Boolean = {
    var cache = new mutable.HashSet[Reference]
    val deep = 30
    var curr: Option[Cell[_]] = Some(this)

    for (l <- 0 until deep) {
      if (curr.isEmpty)
        return false

      if (!curr.get.isInstanceOf[ReferenceCell])
        return false

      val refCurr = curr.get.asInstanceOf[ReferenceCell]

      if (cache.contains(refCurr.value.get))
        return true

      cache += refCurr.value.get
      curr = refCurr.value.get.table.getCell(
        refCurr.value.get.ix,
        refCurr.value.get.iy
      )
    }

    return false
  }
}
