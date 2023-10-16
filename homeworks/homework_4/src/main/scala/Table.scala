import scala.collection.mutable

class Table(w: Int, h: Int) {
  private val cells: Array[Cell] = new Array[Cell](w * h).map(_ => EmptyCell())

  def getCell(ix: Int, iy: Int): Option[Cell] =
    if (checkCorrectCellInTable(ix, iy)) {
      Some(cells(ix + iy*w))
    } else None

  def setCell(ix: Int, iy: Int, cell: Cell): Unit =
    if (checkCorrectCellInTable(ix, iy)) {
      cells(ix + iy * w) = cell
    }

  private def checkCorrectCellInTable(x: Int, y: Int) : Boolean =  x > -1 && y > -1 && x < w && y < h
}