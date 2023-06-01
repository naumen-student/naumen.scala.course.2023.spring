class Table(width: Int, height: Int) {
  private val table: Array[Cell] = Array.fill(width * height) {
    new EmptyCell
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    val location = getLocation(ix, iy)
    if (location.isEmpty)
      return None
    Some(table(location.get))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    val location = getLocation(ix, iy)
    if (location.isEmpty)
      return
    table(location.get) = cell
  }

  private def getLocation(ix: Int, iy: Int): Option[Int] = {
    val location = ix + iy * width
    if (location > table.length || ix < 0 || iy < 0)
      return None
    Some(location)
  }
}