package com.example.myapplication

fun main(){
    var value1 = 10
    var value2 = 5

    println("${value1} 더하기 ${value2} 의 결과는 ${Calculator.Add(value1, value2)}")
    println("${value1} 빼기 ${value2} 의 결과는 ${Calculator.Substract(value1, value2)}")
    println("${value1} 곱하기 ${value2} 의 결과는 ${Calculator.Multiply(value1, value2)}")
    println("${value1} 나누기 ${value2} 의 결과는 ${Calculator.Divide(value1, value2)}")
}

object Calculator {

    fun Add(num1:Int, num2:Int) : Int {
        return num1 + num2
    }
    fun Substract(num1:Int, num2:Int) : Int {
        return num1 - num2
    }
    fun Multiply(num1:Int, num2:Int) : Int {
        return num1 * num2
    }
    fun Divide(num1:Int, num2:Int) : Int {
        return num1 / num2
    }
}