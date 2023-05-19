trait Cell

class EmptyCell extends Cell {
    override def toString(): String = "empty"
}

class NumberCell(number: Int) extends Cell {
    override def toString(): String = number.toString
}

class StringCell(string: String) extends Cell {
    override def toString(): String = string
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
    override def toString(): String = toString(Set[ReferenceCell]())

    private def toString(visited: Set[ReferenceCell]): String = table.getCell(ix, iy) match {
        case None => "outOfRange"
        case Some(value) => {
            if (visited.contains(this))
                return "cyclic"

            value match {
                case reference: ReferenceCell => reference.toString(visited + this)
                case cell: Cell => cell.toString
            }
        }
    }
}