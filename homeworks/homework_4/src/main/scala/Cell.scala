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

class ReferenceCell(x: Int, y: Int, table: Table) extends Cell {
  private def isCyclic(prev: List[ReferenceCell] = List[ReferenceCell]()): Boolean = {
    if (prev.contains(this)) return true
    table.getCell(x, y) match {
      case None => false
      case Some(cell) => cell match {
        case referenceCell: ReferenceCell => referenceCell.isCyclic(prev :+ this)
        case _ => false
      }
    }
  }

  override def toString: String = {
    if (isCyclic()) return "cyclic"
    table.getCell(x, y) match {
      case None => "outOfRange"
      case Some(cell) => cell.toString
    }
  }
}