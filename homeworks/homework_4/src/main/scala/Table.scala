class Table(private val width: Int, private val height: Int) {
  private val table: Array[Cell] = Array.fill(width * height) { new EmptyCell() }
  
  def getCell(x: Int, y: Int): Option[Cell] = if (x < height && x >= 0 && y < width && y >= 0) Some(table(x * width + y)) else None

  def setCell(x: Int, y: Int, cell: Cell): Unit = if (x < height && x >= 0 && y < width && y >= 0) table(x * width + y) = cell
}