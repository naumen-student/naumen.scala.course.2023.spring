import scala.annotation.tailrec
import scala.collection.immutable.HashSet

trait Cell {
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

class StringCell(string: String) extends Cell {
  override def toString: String = string
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = getValueString(HashSet.empty)

  @tailrec
  private def getValueString(lastReferences: HashSet[ReferenceCell]): String = {
    if (lastReferences.contains(this)) return "cyclic"

    table.getCell(ix, iy) match {
      case Some(next: ReferenceCell) => next.getValueString(lastReferences + this)
      case Some(value) => value.toString
      case None => "outOfRange"
    }
  }
}