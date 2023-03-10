package scala

import scala.math.BigDecimal.RoundingMode


object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        "test_sumOfDivBy3Or5" - {
            assert(Exercises.sumOfDivBy3Or5(1,10)==33)
            assert(Exercises.sumOfDivBy3Or5(1,-10)==0)
            assert(Exercises.sumOfDivBy3Or5(5,5)==5)
            assert(Exercises.sumOfDivBy3Or5(-5,5)==0)
            /*assert(Exercises.sumOfDivBy3Or5(Int.MinValue,Int.MaxValue)==0)
            assert(Exercises.sumOfDivBy3Or5(Int.MinValue,0)== -1076060070465310994L)
            assert(Exercises.sumOfDivBy3Or5(0,Int.MaxValue)== 1076060070465310994L)*/
        }
        "test_primeFactor" - {
            assert(Exercises.primeFactor(1)==Seq())
            assert(Exercises.primeFactor(80)==Seq(2,5))
            assert(Exercises.primeFactor(98)==Seq(2,7))
            assert(Exercises.primeFactor(900)==Seq(2,3,5))
            assert(Exercises.primeFactor(121)==Seq(11))
            assert(Exercises.primeFactor(122)==Seq(2,61))
            assert(Exercises.primeFactor(Int.MaxValue)==Seq(Int.MaxValue))
        }

        "test_sumByFunc"-{
            var x1=Exercises.Vector2D(1,2)
            var x2=Exercises.Vector2D(1,2)
            var y1=Exercises.Vector2D(1,2)
            var y2=Exercises.Vector2D(1,3)


            assert(Exercises.sumByFunc(x1,x2,Exercises.scalar,y1,y2)==12)
            assert(
                BigDecimal(Exercises.sumByFunc(x1,x2,Exercises.cosBetween,y1,y2)).setScale(5,RoundingMode.HALF_UP)
              ==
              BigDecimal(1.9899494936611664).setScale(5,RoundingMode.HALF_UP))
            y2=Exercises.Vector2D(1,2)
            assert(Exercises.sumByFunc(x1,x2,Exercises.scalar,y1,y2)==10)
            assert(Exercises.sumByFunc(x1,x2,Exercises.cosBetween,y1,y2)==2)
        }

        "test_sortByHeavyweight" -{
            assert(Exercises.sortByHeavyweight(Exercises.balls)== Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten", "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"))
            assert(Exercises.sortByHeavyweight(
                Map("Aluminum" -> (3, 2.6889),"WrongItem"->(-1,100)))==Seq("WrongItem","Aluminum"))
            assert(Exercises.sortByHeavyweight(
                Map("Aluminum" -> (3, 2.6889),"WrongItem"->(100,-100)))==Seq("WrongItem","Aluminum"))

        }
    }
}
