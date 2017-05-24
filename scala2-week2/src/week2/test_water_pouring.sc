package week2

object test_water_pouring {
  val problem  = new WaterPouring(Vector(4,9, 19))//> problem  : week2.WaterPouring = week2.WaterPouring@47f6473
  
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with w
                                                  //| eek2.test_water_pouring.problem.Move] = Vector(Empty(0), Empty(1), Empty(2),
                                                  //|  Fill(0), Fill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour
                                                  //| (2,0), Pour(2,1))
  problem.pathSets.take(3).toList                 //> res1: List[Set[week2.test_water_pouring.problem.Path]] = List(Set(--> Vector
                                                  //| (0, 0, 0)), Set(Fill(0)--> Vector(4, 0, 0), Fill(1)--> Vector(0, 9, 0), Fill
                                                  //| (2)--> Vector(0, 0, 19)), Set(Fill(1),Pour(1,0)--> Vector(4, 5, 0), Fill(2),
                                                  //| Fill(0)--> Vector(4, 0, 19), Fill(0),Pour(0,2)--> Vector(0, 0, 4), Fill(2),P
                                                  //| our(2,1)--> Vector(0, 9, 10), Fill(0),Fill(1)--> Vector(4, 9, 0), Fill(2),Po
                                                  //| ur(2,0)--> Vector(4, 0, 15), Fill(2),Fill(1)--> Vector(0, 9, 19), Fill(1),Po
                                                  //| ur(1,2)--> Vector(0, 0, 9), Fill(0),Fill(2)--> Vector(4, 0, 19), Fill(0),Pou
                                                  //| r(0,1)--> Vector(0, 4, 0), Fill(1),Fill(2)--> Vector(0, 9, 19), Fill(1),Fill
                                                  //| (0)--> Vector(4, 9, 0)))
  problem.solution(17)                            //> res2: Stream[week2.test_water_pouring.problem.Path] = Stream(Fill(0),Fill(1)
                                                  //| ,Pour(0,2),Pour(1,2),Fill(0),Pour(0,2)--> Vector(0, 0, 17), ?)
}