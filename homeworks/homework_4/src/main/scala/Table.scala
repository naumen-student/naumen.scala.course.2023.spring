import scala.collection.mutable

class Table(width: Int, height: Int) {
    private val cells: mutable.Seq[Cell] = mutable.Seq.fill(height * width)(new EmptyCell())

    def getCell(ix: Int, iy: Int): Option[Cell] = {
        if ((ix < 0 || ix >= width) || (iy < 0 || iy >= height)) {
            return None
        }
        Some(cells(ix + iy * width))
    }

    def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
        if ((ix < 0 || ix >= width) || (iy < 0 || iy >= height)) {
            return
        }
        cells(ix + iy * width) = cell
    }
}
