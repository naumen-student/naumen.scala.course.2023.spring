import scala.annotation.tailrec
import scala.collection.mutable

trait Cell {
  def toString: String
}

class EmptyCell extends Cell {
  override def toString = "empty"
}

class NumberCell(val value: Int) extends Cell {
  override def toString: String = value.toString
}

class StringCell(val value: String) extends Cell {
  override def toString: String = value
}

class ReferenceCell(private val x: Int, private val y: Int, private val table: Table) extends Cell {
  private val chain = new mutable.MutableList[ReferenceCell]()

  @tailrec
  private def getChainEnd(chain: mutable.MutableList[ReferenceCell] = this.chain) : Cell = {
    val i = table.getCell(x, y).get
    i match {
      case ref: ReferenceCell =>
        if (chain.contains(ref)) {
          return new StringCell("cyclic")
        }
        chain += this
        ref.getChainEnd(chain)
      case other => other
    }
  }

  override def toString: String = getChainEnd().toString
}