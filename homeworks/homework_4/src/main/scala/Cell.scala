trait Cell

case class EmptyCell() extends Cell {
    override def toString: String = "empty"
}

case class NumberCell(value: Int) extends Cell {
    override def toString: String = value.toString
}

case class StringCell(value: String) extends Cell {
    override def toString: String = value
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
    override def toString: String = toStringImpl(Set(this))

    private def toStringImpl(refCellsChain: Set[Cell]): String = {
        table.getCell(ix, iy).map {
            case refCell: ReferenceCell =>
                Some(!refCellsChain.contains(refCell))
                        .filter(_ == true)
                        .map(_ => refCell.toStringImpl(refCellsChain ++ Set(refCell)))
                        .getOrElse("cyclic")

            case cell: Cell => cell.toString
        }.getOrElse("outOfRange")
    }
}


