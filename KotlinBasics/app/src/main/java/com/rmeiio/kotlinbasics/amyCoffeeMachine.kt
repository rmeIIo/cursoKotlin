package com.rmeiio.kotlinbasics

fun main() {
    print("Who is this coffee for? ")
    var name = readln()

    print("How many spoons of sugar do you want? ")
    var sugarCount = readln().toInt()

    makeCoffee(sugarCount, name)
}

fun makeCoffee(sugarCount : Int, name : String) {
    if(sugarCount < 1) {
        println("Coffee without sugar for $name")
        return
    } else if (sugarCount == 1) {
        println("Coffee with $sugarCount spoon of sugar for $name")
        return
    } else {
        println("Coffee with $sugarCount spoons of sugar for $name")
    }
}