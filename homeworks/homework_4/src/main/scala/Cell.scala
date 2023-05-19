trait Cell

class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

class NumberCell(int: Int) extends Cell {
  override def toString: String = int.toString
}

class StringCell(str: String) extends Cell {
  override def toString: String = str
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = {
    getNextCell match {
      case Some(cell: ReferenceCell) => if (cell.getNextCell == Option(this)) "cyclic" else cell.toString
      case Some(cell: Cell) => cell.toString
      case None => "outOfRange"
    }
  }

  def getNextCell: Option[Cell] = table.getCell(ix, iy)
}
