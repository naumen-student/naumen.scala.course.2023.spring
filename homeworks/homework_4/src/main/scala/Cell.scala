trait Cell {
  def toString: String
}

class EmptyCell extends Cell {override def toString: String = "empty"}

class NumberCell(number: Int) extends Cell {override def toString: String = number.toString}

class StringCell(string: String) extends Cell {  override def toString: String = string}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {

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
