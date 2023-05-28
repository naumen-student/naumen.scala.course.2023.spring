trait ITable{
	def getCell(ix: Int, iy: Int): Option[Cell]
	def setCell(ix: Int, iy: Int, cell: Cell): Unit
}

class Table(width: Int, height: Int) extends ITable{
	private val cells: Array[Array[Cell]] = Array.fill[Array[Cell]](width)(Array.fill[Cell](height)(new EmptyCell))
	override def getCell(ix: Int, iy: Int): Option[Cell] = {
		if (ix < width && iy < height && ix >= 0 && iy >= 0)
		Option(cells(ix)(iy)) else None
	}

	override def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
		cells(ix)(iy) = cell
	}
}