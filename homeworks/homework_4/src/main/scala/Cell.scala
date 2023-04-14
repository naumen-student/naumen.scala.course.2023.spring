
trait Cell

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(val n: Int) extends Cell {
  override def toString: String = n.toString
}

class StringCell(val s: String) extends Cell {
  override def toString: String = s
}

class ReferenceCell(val ix: Int, val iy: Int, val table: Table) extends Cell {

  override def toString: String = {
    getNextCell match {
      case Some(cell: ReferenceCell) => if (cell.getNextCell == Option(this)) "cyclic" else cell.toString
      case Some(cell: Cell) => cell.toString
      case None => "outOfRange"
    }
  }

  private def getNextCell: Option[Cell] = table.getCell(ix, iy)
}

