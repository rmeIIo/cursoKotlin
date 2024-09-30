package com.rmeiio.kotlinbasics

fun main() {
    var age = 0

    print("Enter your age: ")
    age = readln().toInt()

    if(age in 18 .. 39) {
        println("You can go into the club")
    } else if(age > 40) {
        println("You are too old to go into the club")
    } else {
        println("You are too young to go into the club")
    }
}