package com.nonpool

import scala.collection.Seq
import scala.collection.`Seq$`
import scala.runtime.BoxedUnit
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor

fun main() {
//    applyScalaCustomer()
//    println("---------------")
//    applyScalaNormal()
//    println("---------------")
//    applyScalaCompanion()
//    println("---------------")
//    applyScalaFunctions()
//    println("---------------")
//    applyScalaFunctions2()
    test()
}

fun test() {
    val customer = KotlinCustomer("name", "email", "company")
    val klass = customer::class
    klass.primaryConstructor
    readProperties(customer)
}

fun readProperties(instance: Any) {
    val clazz = instance.javaClass.kotlin
    clazz.declaredMemberProperties.forEach {
        println("${it.name} --[${it.returnType}]---> ${it.get(instance)}")
    }
}

fun applyKotlinCustomer() {
    val customer = KotlinCustomer("name", "email", "company")
    val copy = customer.copy(name = "name1")
    println(customer)
    println("copied customer: $copy")
}

fun applyScalaCustomer() {
    val scalaCustomer = ScalaCustomer("name", "email", "company")
    val copy = scalaCustomer.copy("1", "2", "3")
    println(scalaCustomer)
    println("copied customer: $copy")
}

fun applyScalaNormal() {
    val scalaNormal = ScalaNormal()
    val add2 = scalaNormal.add2(1, 2)
    println("normal add : $add2")
}

fun applyScalaCompanion() {
    ScalaNormal.callNonStatic()
    ScalaNormal.callStatic()
    println(ScalaNormal().add2(1, 2))
    // 甚至可以这样访问
    `ScalaNormal$`.`MODULE$`.callNonStatic()
    println(ScalaNormal.apply())
}

fun applyDefaultParameterMethod() {
//    ScalaNormal().add3(1,2) //报错
    ScalaNormal().add3(1, 2, 3)
}

fun applyScalaFunctions() {
//    ScalaFunctions().executeBlock { println("apply scala functions") } 报错
    val scalaFunctions = ScalaFunctions()
    scalaFunctions.executeBlock {
        println("apply scala functions")
        BoxedUnit.UNIT
    }

}

fun applyScalaFunctions2() {
    val scalaFunctions = ScalaFunctions()
    val executeBlock2 = scalaFunctions.executeBlock2("123") { str ->
        scalaFunctions.listToSeq(str.toCharArray().map { it.code }.toList()) as Seq<Any>
    }
    println("executeBlock2: $executeBlock2")
}
