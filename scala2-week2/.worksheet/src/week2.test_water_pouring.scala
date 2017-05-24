package week2

object test_water_pouring {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
  val problem  = new WaterPouring(Vector(4,9, 19));System.out.println("""problem  : week2.WaterPouring = """ + $show(problem ));$skip(19); val res$0 = 
  
  problem.moves;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Product with Serializable with week2.test_water_pouring.problem.Move] = """ + $show(res$0));$skip(34); val res$1 = 
  problem.pathSets.take(3).toList;System.out.println("""res1: List[Set[week2.test_water_pouring.problem.Path]] = """ + $show(res$1));$skip(23); val res$2 = 
  problem.solution(17);System.out.println("""res2: Stream[week2.test_water_pouring.problem.Path] = """ + $show(res$2))}
}
