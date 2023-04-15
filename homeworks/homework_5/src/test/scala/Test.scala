import Exercises._
import utest._

object Test extends TestSuite {

  val tests = Tests {

    //Test task 1

    val s1: Shelter[Cat] = Shelter(List(Cat("Garfield")))

    val s2: Shelter[Dog] = Shelter(List(Dog("Goofy")))

    val s3: Shelter[Animal] = s1 ++ s2

    val s4 = s3 + Cat("Kuzya")

    assert(s4.getNames.toSet == Set("Garfield", "Goofy", "Kuzya"))

    val s5: Shelter[Animal] = s1 + Dog("Barbos")

    assert(s5.getNames.toSet == Set("Garfield", "Barbos"))

    val s6: Shelter[Dog] = s2 + Dog("Barbos")

    assert(s6.getNames.toSet == Set("Goofy", "Barbos"))

    //Test task 2

    val r1 = s1.feed(Meat)

    assert(r1.toSet == Set("Garfield eats meat"))

    val r2 = s1.feed(Milk)

    assert(r2.toSet == Set("Garfield eats milk"))

    val r3 = s2.feed(Meat)

    assert(r3.toSet == Set("Goofy eats meat"))

    val r4 = s2.feed(Bread)

    assert(r4.toSet == Set("Goofy eats bread"))

    val r5 = s4.feed(Meat)

    assert(
      r5.toSet == Set(
        "Garfield eats meat",
        "Goofy eats meat",
        "Kuzya eats meat"
      )
    )

  }

}
