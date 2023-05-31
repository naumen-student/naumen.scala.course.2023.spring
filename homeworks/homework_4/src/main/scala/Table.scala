import scala.collection.mutable

class Table(w:Int, h:Int) {
    val table: mutable.Seq[Cell] =mutable.Seq.fill(w*h){new EmptyCell}

  private def inBounds(ix: Int,iy: Int): Boolean = {
    (0 <= ix && ix < w) && (0 <= iy && iy < h)
  }

    def getCell(ix: Int, iy: Int) :Option [Cell] = {
        if (inBounds(ix,iy)) Some(table(ix + iy * w)) else
        None
    }

    def setCell(ix: Int, iy: Int, cell: Cell): Unit ={
      if (inBounds(ix,iy)) (table(ix + iy * w)=cell)
    }

}
