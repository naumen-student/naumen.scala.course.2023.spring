trait Cell {
  def toString: String
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
  def isCyclic(previous: List[ReferenceCell] = List[ReferenceCell]()): Boolean = {
    if (previous.contains(this))
      return true

    table.getCell(ix, iy) match {
      case None => false
      case Some(cell) => cell match {
        case referenceCell: ReferenceCell => referenceCell.isCyclic(previous :+ this)
        case _ => false
      }
    }
  }

  override def toString: String = {
    if (isCyclic())
      return "cyclic"

    table.getCell(ix, iy) match {
      case None => "outOfRange"
      case Some(cell) => cell.toString
    }
  }
}