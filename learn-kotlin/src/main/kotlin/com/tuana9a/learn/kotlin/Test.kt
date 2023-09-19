package com.tuana9a.learn.kotlin

import com.tuana9a.learn.kotlin.oop.Rectangle

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum1(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

fun main(args: Array<String>) {
    println(args.contentToString())
    println(sum(1, 2))
    println(sum(1, 3))
    printSum(2, 3)
    val rectangle = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle.perimeter}")

    // lamda expression
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .map { x -> x.length }
        .forEach { println(it) }
}