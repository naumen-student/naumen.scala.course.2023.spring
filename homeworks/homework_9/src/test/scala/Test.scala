import org.scalatest._
import flatspec._
import matchers._

class Test extends AnyFlatSpec with should.Matchers {

  "foldOption" should "return None on empty list" in {
    ListOps.foldOption[Any](_ == _)(DataList.EmptyList) should be (None)
  }

  "foldOption" should "work correct on non empty list" in {
    ListOps.foldOption[String](_ ++ _)(DataList("1", "2", "3")) should be (Some("123"))
  }

  "sum" should "work correctly" in {
    ListOps.sum[Int](DataList(1, 2, 3)) should be (6)
  }

  "filter" should "work correctly" in {
    ListOps.filter[Int](_ % 2 == 0)(DataList((0 to 4).toList: _*)) should be (DataList(0, 2, 4))
  }

  "collect" should "work correctly" in {
    ListOps.collect[Int, String] {
      case i: Int if i % 2 == 0 => i.toString
    }(DataList((0 to 4).toList: _*)) should be (DataList("0", "2", "4"))
  }

}
