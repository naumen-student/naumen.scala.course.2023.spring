class Table(width: Int, height: Int) {
  private val cells: Array[Cell] = Array.fill(width * height)(new EmptyCell)

  private def getPosition(x: Int, y: Int): Option[Int] = {
    val pos = x + y * width
    if (x < 0 || y < 0 || pos > cells.length) return None
    Some(pos)
  }

  def getCell(x: Int, y: Int): Option[Cell] = {
    val pos = getPosition(x, y)
    if (pos.isEmpty) return None
    Some(cells(pos.get))
  }

  def setCell(x: Int, y: Int, cell: Cell): Unit = {
    val pos = getPosition(x, y)
    if (pos.isEmpty) return
    cells(pos.get) = cell
  }
}
