trait Cell

class EmptyCell extends Cell {
  override def toStrin: String = {
    "empty"
  }
}

//Ячейка с 32-битным целым числом
class NumberCell(number: Int) extends Cell {

  override def toString: String = number.toString()
}

//Ячейка с текстом
class StringCell(line: String) extends Cell {

  override def toString: String = line
}

//Ячейка, содержащая ссылку на другую ячейку
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