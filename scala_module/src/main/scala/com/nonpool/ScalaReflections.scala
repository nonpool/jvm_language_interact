package com.nonpool

import scala.reflect.runtime.universe
import scala.reflect.runtime.universe._

object ScalaReflections {

  def printScalaAllField(): Unit = {
    val members = typeOf[ScalaCustomer].members
    println(f"members: $members")
  }


  def normalCaseClassSerializer(): Unit = {
    val sclaz: universe.Type = typeOf[ScalaCustomer]

    sclaz

  }

  def printKotlinAllField(): Unit = {
    val members = typeOf[KotlinCustomer].members

    println(f"members: $members")
  }

  def main(args: Array[String]): Unit = {
    printScalaAllField()
    println("============")
    printKotlinAllField()
    new KotlinCustomer("name", "email", "company")
  }
}
