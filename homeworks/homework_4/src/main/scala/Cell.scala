trait Cell {}

class EmptyCell() extends Cell {
  override def toString : String= "empty"
}

class NumberCell(num : Int) extends Cell {
  override def toString : String= num.toString
}

class StringCell(val str : String) extends Cell {
  override def toString : String= str
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString : String = {
    refToString(Seq(this))
  }

  private def refToString(cells : Seq[Cell]) : String = {
    val cell = table.getCell(ix, iy)
    cell match {
      case Some(next: ReferenceCell) => if (cells.contains(next)) "cyclic" else next.refToString(cells :+ next)
      case None => "outOfRange"
      case Some(normalCell) => normalCell.toString
    }
  }
}