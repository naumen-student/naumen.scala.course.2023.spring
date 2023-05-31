package scala.collection.mutable

case class Table(width: Integer, height:Integer){


  private var cellsArray: Array[Cell] = Array.fill[Cell](width * height)(new EmptyCell)

  def getCell(ix: Int, iy: Int): Option[Cell] = {
      Some((ix < width) && (iy < height) && (iy > -1) && (ix>-1)).filter(_ == true).map(_ => cellsArray(ix + iy*width))
  }


  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if ((ix < width) && (iy < height) && (iy > -1) && (ix>-1)) cellsArray(ix + iy*width) = cell
  }
}