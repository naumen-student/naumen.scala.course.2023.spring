import scala.annotation.tailrec
import scala.collection.mutable

trait Cell {
  def toString: String
}

class EmptyCell extends Cell {
  override def toString = s"empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

class StringCell(string: String) extends Cell {
  override def toString: String = string
}

class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell {
  override def toString: String = {
    table.getCell(ix, iy) match {
      case None => "outOfRange"
      case Some(cell) =>
        cell match {
          case ref: ReferenceCell => if (this == ref) "cyclic" else ref.toString(mutable.HashSet[Cell](this))
          case other => other.toString
        }
    }
  }

  @tailrec
  private def toString(visited: mutable.HashSet[Cell]): String = {
    table.getCell(ix, iy) match {
      case None => "outOfRange"
      case Some(cell) =>
        cell match {
          case ref: ReferenceCell => if (visited.contains(this)) "cyclic" else ref.toString(visited += this)
          case other => other.toString
        }
    }
  }
}