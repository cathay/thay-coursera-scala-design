package week3

object test_circuits {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  object sim extends Circuits with Parameters
  import sim._

  val in1, in2, sum, carry = new Wire             //> in1  : week3.test_circuits.sim.Wire = week3.Gates$Wire@b684286
                                                  //| in2  : week3.test_circuits.sim.Wire = week3.Gates$Wire@880ec60
                                                  //| sum  : week3.test_circuits.sim.Wire = week3.Gates$Wire@3f3afe78
                                                  //| carry  : week3.test_circuits.sim.Wire = week3.Gates$Wire@7f63425a

  halfAdder(in1, in2, sum, carry)
  probe("sum", sum)                               //> sum 0 value = false
  probe("carry", carry)                           //> carry 0 value = false
  
  in1 setSignal true
  run()                                           //> *** simulation started, time =0 ***
                                                  //| sum 8 value = true
  in2 setSignal true
  run()                                           //> *** simulation started, time =8 ***
                                                  //| carry 11 value = true
                                                  //| sum 16 value = false
  in1 setSignal false
  run()                                           //> *** simulation started, time =16 ***
                                                  //| carry 19 value = false
                                                  //| sum 24 value = true
}