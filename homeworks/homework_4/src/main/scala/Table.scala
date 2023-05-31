
case class Table(w:Int,h:Int) {
  val table: Array[Cell] =Array.fill(w*h){new EmptyCell}
  def getCell(x: Int, y: Int) : Option[Cell] =
      try {
       Option(table(x + y * w))
      }
      catch {
          case e:Exception =>None
      }

  def setCell(x: Int, y: Int, cell: Cell): Unit = try table(x + y * w)=cell

  override def toString: String  = s"${table.mkString("(", ", ", ")")}"
}

