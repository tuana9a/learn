package com.tuana9a.learn.kotlin

fun parseInt(str: String): Int? {
    return str.toInt()
}

fun printProduct(arg1: String, arg2: String) {
    try {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        // print(x * y) // error
        println(x)
        println(y)

        // Using `x * y` yields error because they may hold nulls.
        if (x != null && y != null) {
            // x and y are automatically cast to non-nullable after null check
            println(x * y)
        } else {
            println("'$arg1' or '$arg2' is not a number")
        }
    } catch (e: NumberFormatException) {
        println("reached")
        e.printStackTrace()
    }
}

fun main() {
    printProduct("tuan", "dep trai")
}