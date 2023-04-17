import utest._

object Test extends TestSuite {
    val tests = Tests {
        'test_createTable - {
            val table = new Table(3, 3)
            for (i <- 0 until 9) {
                assert(table.getCell(i / 3, i % 3).map(_.toString) == Some("empty"))
            }
            assert(table.getCell(0, -1).map(_.toString) == None)
            assert(table.getCell(-1, 0).map(_.toString) == None)
            assert(table.getCell(9, 8).map(_.toString) == None)
            assert(table.getCell(8, 9).map(_.toString) == None)
        }
        'test_numberCell - {
            val table = new Table(2, 2)
            val cellInt00 = new NumberCell(5)
            val cellInt11 = new NumberCell(2147483647)
            table.setCell(0, 0, cellInt00)
            table.setCell(1, 1, cellInt11)
            assert(table.getCell(0, 0).map(_.toString) == Some("5"))
            assert(table.getCell(0, 1).map(_.toString) == Some("empty"))
            assert(table.getCell(1, 0).map(_.toString) == Some("empty"))
            assert(table.getCell(1, 1).map(_.toString) == Some("2147483647"))
        }
        'test_stringCell - {
            val table = new Table(2, 2)
            val cellStr01 = new StringCell("01")
            val cellStr10 = new StringCell("10")
            table.setCell(0, 1, cellStr01)
            table.setCell(1, 0, cellStr10)
            assert(table.getCell(0, 0).map(_.toString) == Some("empty"))
            assert(table.getCell(0, 1).map(_.toString) == Some("01"))
            assert(table.getCell(1, 0).map(_.toString) == Some("10"))
            assert(table.getCell(1, 1).map(_.toString) == Some("empty"))
        }
        'test_referenceCell - {
            val table = new Table(3, 3)
            /*ix = 0*/
            val cellStr00 = new StringCell("00")
            val cellRef01 = new ReferenceCell(0, 2, table)
            val cellRef02 = new ReferenceCell(0, 1, table)
            /*ix = 1*/
            val cellInt10 = new NumberCell(10)
            val cellInt11 = new NumberCell(11)
            val cellRef12 = new ReferenceCell(0, 0, table)
            /*ix = 2*/
            val cellEmpty20 = new EmptyCell
            val cellRef21 = new ReferenceCell(1, 1, table)
            val cellRef22 = new ReferenceCell(2, 1, table)
            table.setCell(0, 0, cellStr00)
            table.setCell(0, 1, cellRef01)
            table.setCell(0, 2, cellRef02)
            table.setCell(1, 0, cellInt10)
            table.setCell(1, 1, cellInt11)
            table.setCell(1, 2, cellRef12)
            table.setCell(2, 0, cellEmpty20)
            table.setCell(2, 1, cellRef21)
            table.setCell(2, 2, cellRef22)
            for (i <- 0 until 9) {
                val value = table.getCell(i / 3, i % 3).get.toString
                i match {
                    case 0 => assert(value == "00")
                    case 1 => assert(value == "cyclic")
                    case 2 => assert(value == "cyclic")
                    case 3 => assert(value == "10")
                    case 4 => assert(value == "11")
                    case 5 => assert(value == "00")
                    case 6 => assert(value == "empty")
                    case 7 => assert(value == "11")
                    case 8 => assert(value == "11")
                    case _ => assert(false)
                }
            }
        }
    }
}
