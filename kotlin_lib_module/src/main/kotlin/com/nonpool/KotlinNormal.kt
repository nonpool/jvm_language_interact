package com.nonpool

class KotlinNormal {

    fun add2(a: Int, b: Int): Int {
        return a + b
    }

    fun add3(a: Int, b: Int, c: Int = 0): Int {
        return a + b + c
    }

    fun methodUseKotlinStdlib(str: String): Long {
        return str.trim().toLong()
    }

    companion object {
        @JvmStatic
        fun callStatic() {
            println("callStatic")
        }

        fun callNonStatic() {
            println("callNonStatic")
        }
    }
}