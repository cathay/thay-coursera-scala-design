object stream {

  import scala.math._
  def isPrime(n: Int) = (2 until n) forall (i => n % i != 0)
                                                  //> isPrime: (n: Int)Boolean
  isPrime(3)                                      //> res0: Boolean = true
  //Not efficient because all primes are fetched
  ((3000 to 30000) filter isPrime)(1)             //> res1: Int = 3011

  def streamRange(lo: Int, hi: Int): Stream[Int] =
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi)) //> streamRange: (lo: Int, hi: Int)Stream[Int]

  streamRange(3000, 300000).take(3).toList        //> res2: List[Int] = List(3000, 3001, 3002)
  (3000 to 300000).toStream                       //> res3: scala.collection.immutable.Stream[Int] = Stream(3000, ?)

  (streamRange(1000, 100000) filter isPrime) apply 1
                                                  //> res4: Int = 1013

  def from(n: Int): Stream[Int] = n #:: from(n + 1)
                                                  //> from: (n: Int)Stream[Int]

  val naturals = from(0)                          //> naturals  : Stream[Int] = Stream(0, ?)
  val m4s = naturals map (_ * 4)                  //> m4s  : scala.collection.immutable.Stream[Int] = Stream(0, ?)

  (m4s take 29).toList                            //> res5: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 
                                                  //| 56, 60, 64, 68, 72, 76, 80, 84, 88, 92, 96, 100, 104, 108, 112)

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]
  val primes = sieve(from(2))                     //> primes  : Stream[Int] = Stream(2, ?)

  primes.take(20).toList                          //> res6: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 4
                                                  //| 7, 53, 59, 61, 67, 71)
  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }                                               //> sqrtStream: (x: Double)Stream[Double]

  def isGoodEnough(guess: Double, x: Double) = math.abs((guess * guess - x) / x) < 0.0001
                                                  //> isGoodEnough: (guess: Double, x: Double)Boolean
  sqrtStream(4).take(4).toList                    //> res7: List[Double] = List(1.0, 2.5, 2.05, 2.000609756097561)
  sqrtStream(4).filter(isGoodEnough(_,4)).take(10).toList
                                                  //> res8: List[Double] = List(2.0000000929222947, 2.000000000000002, 2.0, 2.0, 
                                                  //| 2.0, 2.0, 2.0, 2.0, 2.0, 2.0)
}