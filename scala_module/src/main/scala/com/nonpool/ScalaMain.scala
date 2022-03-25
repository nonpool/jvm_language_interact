package com.nonpool

import java.util

object ScalaMain {
  def main(args: Array[String]): Unit = {
    applyKotlinNormalMethod()
    println("---------------")
    applyKotlinDataClass()
    println("---------------")
    applyKotlinCompanionObject()
    println("---------------")
    applyKotlinExtendMethod()
    println("---------------")
    applyKotlinFunctions()
  }

  def applyKotlinNormalMethod(): Unit = {
    val kotlinNormal = new KotlinNormal()
    val i = kotlinNormal.add2(1, 2)
    println(kotlinNormal.methodUseKotlinStdlib(" 2 "))
    println(s"add2 : $i")
  }

  def applyKotlinDataClass(): Unit = {
    val customer = new KotlinCustomer("name", "email", "company")
    // 跟java一样只能访问copy方法 且需要传入所有参数
    println(customer.copy("1", "2", "3"))
  }

  def applyKotlinCompanionObject(): Unit = {
    KotlinNormal.callStatic()
  }

  def applyDefaultParameterMethod(): Unit = {
//        new KotlinNormal().add3(1, 2) 报错 所有默认参数的方法无法互通
    new KotlinNormal().add3(1, 2, 3)
  }

  def applyKotlinExtendMethod(): Unit = {
    KotlnExtendKt.extendMethod(new KotlinCustomer("1", "2", "3"))
  }

  def applyKotlinFunctions(): Unit = {
    val functions = new KotlinFunctions()
//    functions.executeBlock(() => println("apply kotlin functions"))  报错
    functions.executeBlock(() => {
      println("apply kotlin functions")
      kotlin.Unit.INSTANCE
    })

    val integers = functions.executeBlock2("123", (str: String) => {
      import scala.collection.JavaConverters._
      str.toCharArray.map(_.toInt).map(new Integer(_)).toList.asJava
    })
    println(f"executeBlock2 restult: $integers")
  }

}
