import scala.collection.mutable.MutableList

class Table(width: Int, height: Int) {
  var matrix = Array.fill[Cell[_]](height * width)(new EmptyCell())

  private def getIndex(ix: Int, iy: Int): Int = iy * width + ix

  def getCell(ix: Int, iy: Int): Option[Cell[_]] =
    if (!containsCell(ix, iy))
      None
    else Some(matrix(getIndex(ix, iy)))

  def setCell(ix: Int, iy: Int, cell: Cell[_]): Unit =
    if (!containsCell(ix, iy))
      throw new IndexOutOfBoundsException(
        s"Cannot insert cell, indexes $ix and $iy are not in the table"
      )
    else matrix(getIndex(ix, iy)) = cell

  def containsCell(ix: Int, iy: Int): Boolean =
    matrix.indices.contains(getIndex(ix, iy))
}
