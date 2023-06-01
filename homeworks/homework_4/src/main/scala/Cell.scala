import scala.annotation.tailrec

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

class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell {
  override def toString: String = {
    if (table.getCell(ix, iy).isEmpty) return "outOfRange"
    if (isCyclic(this, table.getCell(ix, iy).get)) return "cyclic"
    else table.getCell(ix, iy).get.toString
  }

  @tailrec
  private def isCyclic(startCell: ReferenceCell, currentCell: Cell): Boolean = {
    if (!currentCell.isInstanceOf[ReferenceCell])
      return false
    val refCell = currentCell.asInstanceOf[ReferenceCell]
    if (startCell == refCell)
      return true
    isCyclic(startCell, table.getCell(refCell.ix, refCell.iy).get)
  }
}
