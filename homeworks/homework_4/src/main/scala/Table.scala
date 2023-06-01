import scala.collection.mutable

class Table(width: Integer, length: Integer) {
  private val cells: mutable.Seq[Cell] = mutable.Seq.fill(length * width)(new EmptyCell)

  private def CellsArr(ix: Integer, iy: Integer): Boolean = (0 <= ix && ix < width) && (0 <= iy && iy < length)

  def getCell(ix: Integer, iy: Integer): Option[Cell] =
    if (CellsArr(ix, iy)) Some(cells(ix + iy * width))
    else None

  def setCell(ix: Integer, iy: Integer, cell: Cell): Unit =
    if (CellsArr(ix, iy))
      cells(ix + iy * width) = cell
}
