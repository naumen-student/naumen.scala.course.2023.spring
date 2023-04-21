package homework_3

object Exercises {
    private val booleanValues = Map(true -> "правда", false -> "ложь")

    //Pattern matching
    def prettyBooleanFormatter1(x: Any): String =
    {
        x match {
            case bool: Boolean => booleanValues(bool)
            case _ => x.toString
        }
    }

    def prettyBooleanFormatter2(x: Any): String =
    {
        if (x.getClass == classOf[java.lang.Boolean])
        {
            booleanValues(x.asInstanceOf[Boolean])
        }
        else x.toString
    }

    def prettyBooleanFormatter3(x: Any): String =
    {
        if (x.isInstanceOf[Boolean])
        {
            booleanValues(x.asInstanceOf[Boolean])
        }
        else x.toString
    }

    // По мимо этих вариантов, можно ещё возвращать null или 0 как значение по умолчанию для Int
    def max1(xs: Seq[Int]): Int =
    {
        if (xs.isEmpty) throw new IllegalArgumentException("Collection is empty")
        else xs.max
    }

    def max2(xs: Seq[Int]): Seq[Int] =
    {
        if (xs.isEmpty) Seq.empty
        else Seq(xs.max)
    }

    def max3(xs: Seq[Int]): Option[Int] =
    {
        if (xs.isEmpty) None
        else Option(xs.max)
    }

    def sumIntegers[CollectionType <: Iterable[Int]](xs: CollectionType): Int = xs.sum

    private class NumbersPair(x: Int, y: Int) extends Iterable[Int]{
        override def iterator: Iterator[Int] = Seq[Int](x, y).iterator
    }

    def sum1(x: Int, y: Int): Int = sumIntegers(Seq(x, y))
    def sum2(x: Int, y: Int): Int = sumIntegers(Vector(x, y))
    def sum3(x: Int, y: Int): Int = sumIntegers(new NumbersPair(x, y))
}