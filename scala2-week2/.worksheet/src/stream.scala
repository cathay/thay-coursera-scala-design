object stream {

  import scala.math._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  def isPrime(n: Int) = (2 until n) forall (i => n % i != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(13); val res$0 = 
  isPrime(3);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(87); val res$1 = 
  //Not efficient because all primes are fetched
  ((3000 to 30000) filter isPrime)(1);System.out.println("""res1: Int = """ + $show(res$1));$skip(133); 

  def streamRange(lo: Int, hi: Int): Stream[Int] =
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi));System.out.println("""streamRange: (lo: Int, hi: Int)Stream[Int]""");$skip(44); val res$2 = 

  streamRange(3000, 300000).take(3).toList;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(28); val res$3 = 
  (3000 to 300000).toStream;System.out.println("""res3: scala.collection.immutable.Stream[Int] = """ + $show(res$3));$skip(54); val res$4 = 

  (streamRange(1000, 100000) filter isPrime) apply 1;System.out.println("""res4: Int = """ + $show(res$4));$skip(53); 

  def from(n: Int): Stream[Int] = n #:: from(n + 1);System.out.println("""from: (n: Int)Stream[Int]""");$skip(26); 

  val naturals = from(0);System.out.println("""naturals  : Stream[Int] = """ + $show(naturals ));$skip(33); 
  val m4s = naturals map (_ * 4);System.out.println("""m4s  : scala.collection.immutable.Stream[Int] = """ + $show(m4s ));$skip(24); val res$5 = 

  (m4s take 29).toList;System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(98); 

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0));System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(30); 
  val primes = sieve(from(2));System.out.println("""primes  : Stream[Int] = """ + $show(primes ));$skip(26); val res$6 = 

  primes.take(20).toList;System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(188); 
  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  };System.out.println("""sqrtStream: (x: Double)Stream[Double]""");$skip(91); 

  def isGoodEnough(guess: Double, x: Double) = math.abs((guess * guess - x) / x) < 0.0001;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(31); val res$7 = 
  sqrtStream(4).take(4).toList;System.out.println("""res7: List[Double] = """ + $show(res$7));$skip(58); val res$8 = 
  sqrtStream(4).filter(isGoodEnough(_,4)).take(10).toList;System.out.println("""res8: List[Double] = """ + $show(res$8))}
}
