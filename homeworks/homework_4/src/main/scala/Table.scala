import scala.collection.mutable.ListBuffer

class Table(width: Int, height: Int) {
  val table: ListBuffer[Cell] = ListBuffer.fill[Cell](height * width){ new EmptyCell }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (0 <= ix && ix < width && 0 <= iy && iy < height)
      Some(table(ix + iy * width))
    else None
  }
  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    table(ix + iy * width) = cell
  }
}