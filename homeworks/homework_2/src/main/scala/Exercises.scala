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
        (for {i <- iFrom to iTo
              if i % 3 == 0 || i % 5 == 0
              } yield i).sum
    }


    /*ЗАДАНИЕ II*/
    /*Реализовать функцию, которая вычисляет все различные простые множители целого числа отличные от 1.
    Число 80 раскладывается на множители 1 * 2 * 2 * 2 * 2 * 5, результат выполнения функции => Seq(2, 5).
    Число 98 можно разложить на множители 1 * 2 * 7 * 7, результат выполнения функции => Seq(2, 7).*/
    /*Реализовать юнит-тесты в src/test/scala для данной функции.*/
    def primeFactor(number: Int): Seq[Int] = {
        var remain = number
        var prime = 2
        var result = List[Int]()
        while (remain > 1) {
            while (remain % prime == 0) {
                remain = remain / prime
                if (!result.contains(prime)) result = result :+ prime
            }
            prime += (if (prime % 2 == 0) 1 else 2)
        }
        result
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
    def sumByFunc(leftVec0: Vector2D, leftVec1: Vector2D, f: (Vector2D, Vector2D) => Double, rightVec0: Vector2D, rightVec1: Vector2D): Double = {
        f(leftVec0, leftVec1) + f(rightVec0, rightVec1)
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
}