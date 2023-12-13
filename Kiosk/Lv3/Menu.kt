package com.example.kiosk

open class Menu {
    var name:String
    var price:Int

    constructor(_name:String, _price:Int){
        name = _name
        price = _price
    }

    fun PrintInfo():String{
        return "${name} - ${price}원"
    }
}