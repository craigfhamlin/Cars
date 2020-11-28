package com.haigcramlin.cars

class Car (val make:String, val model: String): Serviceable {
    var races: Int = 0
    var tires:String = "none"
    var oilLevel:String = "fine"
    var oilClean:Boolean = true //Maybe after 10 races this flips to false? I dunno



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