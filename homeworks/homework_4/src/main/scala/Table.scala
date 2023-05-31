import scala.collection.mutable

class Table(val ix: Int, val iy: Int) {
  private val cells = mutable.MutableList.fill[Cell](ix * iy) {
    new EmptyCell
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix >= this.ix || ix < 0
    || iy >= this.iy || iy < 0) {
      None
    } else {
      cells.get(ix + iy * this.ix)
    }
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    cells.update(ix + iy * this.ix, cell)
  }
}