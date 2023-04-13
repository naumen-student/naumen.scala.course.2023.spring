trait Table {
    def getCell(ix: Int, iy: Int): Option[Cell]
    def setCell(ix: Int, iy: Int, cell: Cell): Unit
}

class TableImpl(width: Int, height: Int) extends Table {
    private val cells: Array[Cell] = Array.fill[Cell](width * height)(new EmptyCell)
    private def isInRange(ix: Int, iy: Int): Option[Boolean] = Some(ix < width && iy < height && ix >= 0 && iy >= 0)
    override def getCell(ix: Int, iy: Int): Option[Cell] = isInRange(ix, iy).filter(_ == true).map(_ => cells(iy + ix * width))
    override def setCell(ix: Int, iy: Int, cell: Cell): Unit = isInRange(ix, iy).foreach(_ => cells(iy + ix * width) = cell)
}
