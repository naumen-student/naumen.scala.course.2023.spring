package scala

import scala.math.BigDecimal.RoundingMode

object Exercises {

  /*ПРИМЕР*/
  /*Реализовать функцию, которая возвращает все целые числа в заданном диапазоне (от iForm до iTo), которые делятся
    на 3 или на 7.*/
  /*Реализовать юнит-тесты в src/test/scala для данной функции.*/
  def divBy3Or7(iFrom: Int, iTo: Int): Seq[Int] = {
    for {i <- iFrom to iTo
         if i % 3 == 0 || i % 7 == 0
         } yield i
  }


  /*ЗАДАНИЕ I*/
  /*Реализовать функцию, которая возвращает сумму всех целых чисел в заданном диапазоне (от iForm до iTo), которые делятся
    на 3 или на 5.*/
  /*Реализовать юнит-тесты в src/test/scala для данной функции.*/
  def sumOfDivBy3Or5(iFrom: Int, iTo: Int): Long = {
    var sum = 0L
    for {
      i <- iFrom to iTo
         if i % 3 == 0 || i % 5 == 0
         }
      sum += i
    sum
  }


  /*ЗАДАНИЕ II*/
  /*Реализовать функцию, которая вычисляет все различные простые множители целого числа отличные от 1.
    Число 80 раскладывается на множители 1 * 2 * 2 * 2 * 2 * 5, результат выполнения функции => Seq(2, 5).
    Число 98 можно разложить на множители 1 * 2 * 7 * 7, результат выполнения функции => Seq(2, 7).*/
  /*Реализовать юнит-тесты в src/test/scala для данной функции.*/
  def primeFactor(number: Int): Seq[Int] = {
    if (number==1)
      return Seq()




    def sieve(s: Stream[Int]): Stream[Int] = {
      s.head #:: sieve(s.tail.filter(_ % s.head != 0))
    }
    // All primes as a lazy sequence
    val primes = sieve(Stream.from(2))


    if (2 to math.sqrt(number).toInt forall  (y => number  % y != 0))
      return Seq(number)
    val primePblCanDivide=primes.takeWhile(_<=number).toList

    for {i<-primePblCanDivide
      if number%i==0
    }yield i


  }


  /*ЗАДАНИЕ III*/
  /*Дано: класс двумерного вектора, а также функции вычисления модуля вектора (abs), вычисления скалярного произведения
    векторов (scalar) и косинуса угла между векторами (cosBetween).
    Необходимо: реализовать функцию sumByFunc таким образом, чтобы можно было раскомментировать функции sumScalars и sumCosines.
    Функция sumScalars должна вычислять сумму скалярных произведений для пар векторов scalar(leftVec0, leftVec1) + scalar(rightVec0, rightVec1).
    Функция sumCosines должна вычислять сумму косинусов углов между парами векторов cosBetween(leftVec0, leftVec1) + cosBetween(rightVec0, rightVec1).*/
  /*Реализовать юнит-тесты в src/test/scala для функций sumScalars и sumCosines*/
  case class Vector2D(x: Double, y: Double)

  def abs(vec: Vector2D): Double = java.lang.Math.sqrt(vec.x * vec.x + vec.y * vec.y)

  def scalar(vec0: Vector2D, vec1: Vector2D): Double = vec0.x * vec1.x + vec0.y * vec1.y

  def cosBetween(vec0: Vector2D, vec1: Vector2D): Double = scalar(vec0, vec1) / abs(vec0) / abs(vec1)

  def sumByFunc(leftVec0: Vector2D, leftVec1: Vector2D,
                func:(Vector2D,Vector2D)=>Double, rightVec0: Vector2D, rightVec1: Vector2D): Double
  = {
    func(leftVec0, leftVec1) + func(rightVec0, rightVec1)
  }

    def sumScalars(leftVec0: Vector2D, leftVec1: Vector2D, rightVec0: Vector2D, rightVec1: Vector2D): Double =
        sumByFunc(leftVec0, leftVec1, scalar, rightVec0, rightVec1)


    def sumCosines(leftVec0: Vector2D, leftVec1: Vector2D, rightVec0: Vector2D, rightVec1: Vector2D): Double =
        sumByFunc(leftVec0, leftVec1, cosBetween, rightVec0, rightVec1)



  /*ЗАДАНИЕ IV*/
  /*Дано: коллекция металлических шариков balls, где каждый элемент представлен в виде (Name: String -> (radius: Int, density: Double).
    Здесь radius - радиус шарика [см], а density - плотность материала [г / (см^3)], из которого он изготовлен (например,
    для серебра в коллекции представлен шарик "Silver" радиуса 4 см и плотности 4.505 г / (см^3) )
    Необходимо реализовать функцию sortByHeavyweight, которая принимает коллекцию такого формата и возвращает список названий материалов шариков,
    упорядоченный в зависимости от массы шариков (первый элемент списка соответствует наиболее "лёгкому" шарику, последний - наиболее "тяжёлому").
    В качестве значения числа "Пи" можно использовать java.lang.Math.PI
    */
  /*Реализовать юнит-тесты в src/test/scala для данной функции.*/
  val balls: Map[String, (Int, Double)] =
  Map(
    "Aluminum" -> (3, 2.6889), "Tungsten" -> (2, 19.35), "Graphite" -> (12, 2.1), "Iron" -> (3, 7.874),
    "Gold" -> (2, 19.32), "Potassium" -> (14, 0.862), "Calcium" -> (8, 1.55), "Cobalt" -> (4, 8.90),
    "Lithium" -> (12, 0.534), "Magnesium" -> (10, 1.738), "Copper" -> (3, 8.96), "Sodium" -> (5, 0.971),
    "Nickel" -> (2, 8.91), "Tin" -> (1, 7.29), "Platinum" -> (1, 21.45), "Plutonium" -> (3, 19.25),
    "Lead" -> (2, 11.336), "Titanium" -> (2, 10.50), "Silver" -> (4, 4.505), "Uranium" -> (2, 19.04),
    "Chrome" -> (3, 7.18), "Cesium" -> (7, 1.873), "Zirconium" -> (3, 6.45)
  )

  def sortByHeavyweight(ballsArray: Map[String, (Int, Double)] = balls): Seq[String] = {
    def getWeight(radius:Int,p:Double):Double={
      if (p<0 ||radius<0)
        return 0

      4/3*Math.PI*Math.pow(radius,3)*p
    }

    val res=ballsArray.toSeq.sortBy({case(k,(a,b))=>getWeight(a,b)})
    for {name<-res}yield name._1
  }

  def main(args: Array[String]): Unit = {
    println(divBy3Or7(1, 10))
    println(sumOfDivBy3Or5(1,5))
    println(primeFactor(100).toList)

    println(sortByHeavyweight(balls))

    val x1=Vector2D(1,2)
    val x2=Vector2D(1,2)
    val y1=Vector2D(1,2)
    val y2=Vector2D(1,3)
    println(sumByFunc(x1,x2,cosBetween,y1,y2))
    val b = 6.7
    val c = 1.9899494936611664
    val h = 4.1
    var result = BigDecimal(c).setScale(5,RoundingMode.HALF_UP)
    println(result)


  }
}
