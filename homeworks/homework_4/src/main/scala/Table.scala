import scala.collection.mutable

class Table(val height: Int, val width: Int) {
  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (!isInBounds(ix, iy)) return None
    Some(cells(getIndex(ix, iy)))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (!isInBounds(ix, iy)) throw new ArrayIndexOutOfBoundsException
    cells(getIndex(ix, iy)) = cell
  }

  private def isInBounds(ix: Int, iy: Int): Boolean = {
    ix >= 0 && ix < height && iy >= 0 && iy < width
  }

  private def getIndex(ix: Int, iy: Int): Int = ix + iy * width
  private val length = height * width
  private val cells: mutable.ArraySeq[Cell] = mutable.ArraySeq.fill(length)(new EmptyCell)
}