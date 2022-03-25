package com.nonpool

class ScalaFunctions {
  def executeBlock(block: () => Unit) {
    println("ScalaFunctions executeBlock")
    block()
  }

  def executeBlock2(str: String, block: (String) => Seq[Int]): Seq[Int] = {
    println("ScalaFunctions executeBlock2")
    block(str)
  }


  def listToSeq(i: java.util.List[_]): Seq[_] = Seq(i.toArray: _*)
}
