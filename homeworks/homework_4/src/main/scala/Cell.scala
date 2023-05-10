import scala.annotation.tailrec

trait Cell

case class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

case class NumberCell(value: Int) extends Cell {
  override def toString: String = value.toString
}

case class StringCell(value: String) extends Cell {
  override def toString: String = value
}

case class ReferenceCell(x: Int, y: Int, table: Table) extends Cell {
  override def toString: String = toStringRecursive(Set(this))

  @tailrec
  private def toStringRecursive(visitedCells: Set[Cell]): String = {
    table.getCell(x, y) match {
      case Some(refCell: ReferenceCell) =>
        if (visitedCells.contains(refCell)) "cyclic"
        else refCell.toStringRecursive(visitedCells + refCell)
      case Some(cell) => cell.toString
      case None => "outOfRange"
    }
  }
}