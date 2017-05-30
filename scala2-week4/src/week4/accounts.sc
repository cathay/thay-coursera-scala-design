package week4

object accounts {
  def consolidate(accts: List[BankAccount]): Signal[Int] =
		Signal(accts.map(_.balance()).sum)//> consolidate: (accts: List[week4.BankAccount])week4.Signal[Int]
		
		val a = new BankAccount           //> a  : week4.BankAccount = week4.BankAccount@96532d6
		val b = new BankAccount           //> b  : week4.BankAccount = week4.BankAccount@3796751b
		
		val c = consolidate(List(a,b))    //> c  : week4.Signal[Int] = week4.Signal@327471b5
		c()                               //> res0: Int = 0
		a deposit 30
		c()                               //> res1: Int = 30
		b deposit 20
		
		val xchange = Signal(246.00)      //> xchange  : week4.Signal[Double] = week4.Signal@3a03464
		val inDollar = Signal(c() * xchange())
                                                  //> inDollar  : week4.Signal[Double] = week4.Signal@2d3fcdbd
		
		inDollar()                        //> res2: Double = 12300.0
		b withdraw 10
		inDollar()                        //> res3: Double = 9840.0
}