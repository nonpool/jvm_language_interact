package com.nonpool

// 包含两个高阶函数
class KotlinFunctions {

    fun executeBlock(block: () -> Unit) {
        println("KotlinFunctions executeBlock")
        block()
    }

    fun executeBlock2(str: String, block: (String) -> List<Int>): List<Int> {
        println("KotlinFunctions executeBlock2")

        return block(str)
    }

}