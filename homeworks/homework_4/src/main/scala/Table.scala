class Table(width: Int, height: Int) {
  private val cells: Array[Cell] = Array.fill[Cell](width * height)(new EmptyCell)

  private def inRange(ix: Int, iy: Int): Option[Boolean] = Some(ix >= 0 && iy >= 0 && ix < width && iy < height).filter(b => b)

  def getCell(ix: Int, iy: Int): Option[Cell] = inRange(ix, iy).map(x => cells(ix + iy * width))

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = inRange(ix, iy).foreach(x => cells(ix + iy * width) = cell)
}