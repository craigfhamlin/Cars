package com.haigcramlin.cars

class Truck (val make:String, val model: String): Serviceable {
    var races = 0
    var tires:String = "none"
    var oilLevel:String = "fine"
    var truckEngine: String = "super V12"
    var oilClean:Boolean = true
    override fun changeOil(){
        oilClean = true
    }

    override fun changeTires(tireType: String, numTiresToChange: Int) {
        if(tireType != "remove")
            tires = tireType
        println(tires)
    }

    override fun washWindow(): Boolean {
        TODO("Not yet implemented")
    }

    fun changeTires(tireType: String = "fine"): String{
        if(tireType != "remove")
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