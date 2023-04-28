import scala.collection.mutable

class Table(width: Int, length: Int) {
  private val cells: mutable.Seq[Cell] = mutable.Seq.fill(length * width)(new EmptyCell)

  private def inBounds(ix: Int, iy: Int): Boolean = (0 <= ix && ix < width) && (0 <= iy && iy < length)

  def getCell(ix: Int, iy: Int): Option[Cell] =
    if (inBounds(ix, iy)) Some(cells(ix + iy * width))
    else None

  def setCell(ix: Int, iy: Int, cell: Cell): Unit =
    if (inBounds(ix, iy))
      cells(ix + iy * width) = cell
}