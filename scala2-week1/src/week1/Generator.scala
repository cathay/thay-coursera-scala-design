package week1

trait Generator[+T] {

  self => // an alias for ”this”.

  def generate: T

  def map[S](f: T => S): Generator[S] = new Generator[S] {
    def generate = f(self.generate)
  }

  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    def generate = f(self.generate).generate
  }

}

trait Tree
case class Inner(left: Tree, right: Tree) extends Tree
case class Leaf(x: Int) extends Tree

object Generator {

  import Generator._

  def single[T](x: T): Generator[T] = new Generator[T] {
    def generate = x
  }

  def emptyLists = single(Nil)
  
  val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  }

  val booleans = integers.map(_ > 0)
  
  def choose(lo: Int, hi: Int): Generator[Int] =
    for (x <- integers) yield lo + x % (hi - lo)
  def oneOf[T](xs: T*): Generator[T] =
    for (idx <- choose(0, xs.length)) yield xs(idx)

  def lists: Generator[List[Int]] = for {
    isEmpty <- booleans
    list <- if (isEmpty) emptyLists else nonEmptyLists
  } yield list

  def nonEmptyLists = for {
    head <- integers
    tail <- lists
  } yield head :: tail
  
  def leafs: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x)
  
  def inners: Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l,r)
  
  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if(isLeaf) leafs else inners
  } yield tree
}