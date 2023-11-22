trait Cell

class EmptyCell extends Cell {
  override def toString: Predef.String = "empty"
}

class NumberCell(num: Int) extends Cell {
  override def toString: Predef.String = num.toString

}

class StringCell(string: String) extends Cell {
  override def toString: String = string
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