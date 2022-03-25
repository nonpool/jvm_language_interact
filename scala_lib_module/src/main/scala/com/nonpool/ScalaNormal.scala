package com.nonpool

class ScalaNormal {
  def add2(a: Int, b: Int): Int = {
    a + b
  }

  def add3(a: Int, b: Int, c: Int = 0): Int = {
    a + b + c
  }

  def defaultApply(scalaNormal: ScalaNormal = ScalaNormal()): Unit = {
    println(scalaNormal)
  }
}

object ScalaNormal {
  def apply(): ScalaNormal = {
    println("into ScalaNormal apply")
    new ScalaNormal()
  }

  def callStatic() {
    println("callStatic")
  }

  def callNonStatic() {
    println("callNonStatic")
  }
}
