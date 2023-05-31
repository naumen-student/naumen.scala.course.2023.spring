sealed trait Cell {


}

case class EmptyCell() extends Cell
{
  override def toString: String = "empty"
}

case class NumberCell(int: Int) extends Cell
{
  override def toString: String = s"$int"
}
case class StringCell(string: String) extends Cell
{
  override def toString: String = s"$string"
}
case class ReferenceCell(x:Int,y:Int,table: Table) extends Cell {

  override def toString: String = {
    table.getCell(x, y).map {
      case referenceCell: ReferenceCell => table.getCell(referenceCell.x, referenceCell.y)
        .filter(_ != this)
        .map(_.toString)
        .getOrElse("cyclic")
      case cell: Cell => cell.toString
    }.getOrElse("outOfRange")
  }
}


