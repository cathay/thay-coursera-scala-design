object lazy_evaluation {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(164); 
  def expr = {
    val x = { print("x"); 1 }
    lazy val y = { print("y"); 2 }
    def z = { print("z"); 3 }
    z + y + x + z + y + x
  };System.out.println("""expr: => Int""");$skip(7); val res$0 = 
  expr;System.out.println("""res0: Int = """ + $show(res$0))}
}
