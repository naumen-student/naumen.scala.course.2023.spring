trait Cell {
	def toString: String;
}

class NumberCell(number: Int) extends Cell {
	override def toString: String = number.toString
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
	override def toString: String = {
		getRefCell match {
			case Some(cell: ReferenceCell) => if (cell.getRefCell == Option(this)) "cyclic" else cell.toString
			case Some(cell: Cell) => cell.toString
			case None => "outOfRange"
		}
	}

	private def getRefCell: Option[Cell] = table.getCell(ix, iy)
}

class StringCell(text: String) extends Cell {
	override def toString: String = text
}

class EmptyCell extends Cell {
	override def toString: String = "empty"
}