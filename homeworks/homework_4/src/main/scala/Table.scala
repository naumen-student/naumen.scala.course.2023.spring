class Table(width: Int, height: Int) {
    private val cells = Array.fill[Cell](width, height)(new EmptyCell)

    def getCell(ix: Int, iy: Int): Option[Cell] = if (isInBound(ix, iy)) Some(cells(ix)(iy)) else None

    def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
        if (!isInBound(ix, iy))
            throw new IndexOutOfBoundsException
            
        cells(ix)(iy) = cell
    }

    private def isInBound(ix: Int, iy: Int): Boolean = {
        ix >= 0 && ix < cells.length &&
        iy >= 0 && cells.length > 0 && iy < cells(0).length
    }
}