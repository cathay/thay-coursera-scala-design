package week3

object loops {
  def WHILE(condition: => Boolean)(command: Unit): Unit = {
    if (condition) {
      command
      WHILE(condition)(command)
    } else ()
  }                                               //> WHILE: (condition: => Boolean)(command: Unit)Unit

  def REPEAT(command: Unit)(condition: => Boolean): Unit = {
    command
    if (!condition)
      REPEAT(command)(condition)
    else ()
  }                                               //> REPEAT: (command: Unit)(condition: => Boolean)Unit
  
}