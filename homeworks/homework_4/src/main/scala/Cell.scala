trait Cell {}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(int: Int) extends Cell {
  override def toString: String = int.toString
}

class StringCell(str: String) extends Cell {
  override def toString: String = str
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = toStringImp(this)
    //table.getCell(ix, iy).toString

  private def toStringImp(strCell: ReferenceCell): String = table.getCell(ix, iy)
    .map {
      case refCell: ReferenceCell => Some(refCell != strCell).filter(_ == true).map(_ => refCell.toStringImp(strCell)).getOrElse("cyclic")
      case cell: Cell => cell.toString
    }
    .getOrElse("outOfRange")
}