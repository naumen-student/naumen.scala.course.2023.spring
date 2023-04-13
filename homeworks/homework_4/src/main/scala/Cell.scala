trait Cell

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

class StringCell(str: String) extends Cell {
  override def toString: String = str
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {

  def getValue(cells: Set[Cell] = Set()): String = {
    val cell = table.getCell(ix, iy)
    if (cell.isEmpty)
      return "outOfRange"
    if (cells.contains(cell.get))
      return "cyclic"
    cell.get match {
      case ref: ReferenceCell => ref.getValue(cells + this)
      case cell: Cell => cell.toString
    }
  }

  override def toString: String = getValue()
}

