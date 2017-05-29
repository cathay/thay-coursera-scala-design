object experiment {
  import org.scalacheck._
  import Arbitrary._
  import Gen._
  import Prop._

  val vowel = Gen.oneOf('A', 'E', 'I', 'O', 'U')  //> vowel  : org.scalacheck.Gen[Char] = org.scalacheck.Gen$$anon$2@735b478
  lazy val genMap: Gen[Map[Int, Int]] = oneOf(
    const(Map.empty[Int, Int]),
    for {
      k <- arbitrary[Int]
      v <- arbitrary[Int]
      m <- oneOf(const(Map.empty[Int, Int]), genMap)
    } yield m.updated(k, v))                      //> genMap: => org.scalacheck.Gen[Map[Int,Int]]

  genMap.sample                                   //> res0: Option[Map[Int,Int]] = Some(Map())
  vowel.sample                                    //> res1: Option[Char] = Some(U)

  object BasicScalaCheckProperties extends Properties("Simple Math") {
    property("Sums are associative") = Prop.forAll { (x: Int, y: Int) => x + y == y + x }
  }
  
  
}