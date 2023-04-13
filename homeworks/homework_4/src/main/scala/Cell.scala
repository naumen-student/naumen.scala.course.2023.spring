import scala.annotation.tailrec

sealed trait Cell {
  def toString: String
}

final case class EmptyCell() extends Cell{
  override def toString: String = "empty"
}

final case class NumberCell(number: Int) extends Cell{
  override def toString: String = number.toString
}

final case class StringCell(text: String) extends Cell{
  override def toString: String = text
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = {
    table.getCell(ix, iy) match {
      case None => "outOfRange"
      case Some(cell: ReferenceCell) => if (table.getCell(cell.ix, cell.iy).contains(this)) "cyclic" else cell.toString
      case Some(cell: EmptyCell) => cell.toString
      case Some(cell: NumberCell) => cell.toString
      case Some(cell: StringCell) => cell.toString
      case _ => ""
    }
  }
}