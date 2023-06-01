class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell {
    override def toString: String = {
        val targetCell = table.getCell(ix, iy)

        if (targetCell.isEmpty) {
            return "outOfRange"
        }

        targetCell.get match {
            case castedTargetCell: ReferenceCell =>
                val secondReferenceCell = table.getCell(castedTargetCell.ix, castedTargetCell.iy)
                if (secondReferenceCell.isDefined && this == secondReferenceCell.get) {
                    return "cyclic"
                }
            case _ =>
        }

        targetCell.get.toString
    }
}
