class Table(width: Int, height: Int) {
  private val cells: Array[Cell] = Array.fill(width * height)(new EmptyCell)

  def getCell(x: Int, y: Int): Option[Cell] = {
    if (!isValidIndexes(x, y)) return None
    Some(cells(x + y * width))
  }

  def setCell(x: Int, y: Int, cell: Cell): Unit = {
    if (isValidIndexes(x, y)) cells(x + y * width) = cell
  }

  private def isValidIndexes(x: Int, y: Int): Boolean = {
    x < width && y < height && x >= 0 && y >= 0
  }
}