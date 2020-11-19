package com.haigcramlin.cars

class Car (val make:String, val model: String) {
    var races = 0
    var tires:String = "none"
    var oilLevel:String = "fine"

    fun changeTires(tireType: String = "toyo"): String{
        if(tireType != "crappy")
            tires = tireType
        println(tires)
        return tires
    }

    fun oilCheck(level: String = "don't fill"): String{
        if(oilLevel != "low")
            oilLevel = level
        println(oilLevel)
        return oilLevel
    }

}