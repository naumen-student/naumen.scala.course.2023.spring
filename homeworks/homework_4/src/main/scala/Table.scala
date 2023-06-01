class Table(width: Int, height: Int) {
  private val cells: Array[Cell] = Array.fill(width * height)(new EmptyCell)

  private def getPosition(ix: Int, iy: Int): Option[Int] = {
    val pos = ix + iy * width
    if (ix < 0 || iy < 0 || pos > cells.length)
      return None
    Some(pos)
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    val pos = getPosition(ix, iy)
    if (pos.isEmpty)
      return None
    Some(cells(pos.get))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    val pos = getPosition(ix, iy)
    if (pos.isEmpty)
      return
    cells(pos.get) = cell
  }
}