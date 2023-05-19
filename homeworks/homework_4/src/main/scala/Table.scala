class Table(width: Int, height: Int) {
  private val CellsArray: Array[Cell] = Array.fill(width * height){ new EmptyCell }

  private def getIndex(ix: Int, iy: Int): Int = {
    ix + iy * width
  }

  private def isValid(ix: Int, iy: Int): Boolean = {
    (0 until width contains ix) && (0 until height contains iy)
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (!isValid(ix, iy)) return None
    Some(CellsArray(getIndex(ix, iy)))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (isValid(ix, iy)) CellsArray(getIndex(ix, iy)) = cell
  }
}
