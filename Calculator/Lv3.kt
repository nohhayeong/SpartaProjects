package com.example.myapplication

fun main(){
    var value1 = 20
    var value2 = 6

    var calculatorList = mutableListOf<Calculator>(AddOperation(), SubstractOperation(),
        MultiplyOperation(), DivideOperation())

    println("${value1} 더하기 ${value2} 의 결과는 ${calculatorList[0].Calculate(value1, value2)}")
    println("${value1} 빼기 ${value2} 의 결과는 ${calculatorList[1].Calculate(value1, value2)}")
    println("${value1} 곱하기 ${value2} 의 결과는 ${calculatorList[2].Calculate(value1, value2)}")
    println("${value1} 나누기 ${value2} 의 결과는 ${calculatorList[3].Calculate(value1, value2)}")
}

open class Calculator {
    open fun Calculate(num1:Int, num2:Int) : Int {
        return 0
    }
}

class AddOperation() : Calculator() {
    override fun Calculate(num1:Int, num2:Int) : Int {
        return num1 + num2
    }
}

class SubstractOperation() : Calculator() {
    override fun Calculate(num1:Int, num2:Int) : Int {
        return num1 - num2
    }
}

class MultiplyOperation() : Calculator() {
    override fun Calculate(num1:Int, num2:Int) : Int {
        return num1 * num2
    }
}

class DivideOperation() : Calculator() {
    override fun Calculate(num1:Int, num2:Int) : Int {
        return num1 / num2
    }
}