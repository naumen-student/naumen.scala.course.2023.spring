
import scala.collection.mutable.Seq

class Table(width: Int, height: Int) {
  private val cells : Seq[Cell] = Seq.fill[Cell](width * height) { new EmptyCell}

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix < 0 || iy < 0 || ix >= width || iy >= height) None else Option(cells(ix + iy * width))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (!(ix < 0 || iy < 0 || ix >= width || iy >= height)) cells(ix + iy * width) = cell
  }
}
