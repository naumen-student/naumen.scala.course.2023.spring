class Table(width: Int, height: Int) {

  private val cellsArray: Array[Cell] = Array.fill[Cell](width * height)(new EmptyCell)

  private def inRangeAsOpt(ix: Int, iy: Int): Option[Boolean] = Some(ix < width && iy < height && ix > -1 && iy > -1).filter(_ == true)

  def getCell(ix: Int, iy: Int): Option[Cell] = inRangeAsOpt(ix, iy).map(_ => cellsArray(iy + ix * width))


  def setCell(ix: Int, iy: Int, cell: Cell): Unit = inRangeAsOpt(ix, iy).foreach(_ => cellsArray(iy + ix * width) = cell)

}