package com.haigcramlin.cars

interface Serviceable {
   fun changeOil()
   fun changeTires(tireType:String, numTiresToChange:Int)
   fun washWindow():Boolean
}



class Garage (val name: String){
    fun fullService(vehicle:Serviceable) {
        vehicle.changeTires("toyo", 4)  // do we need to add toyo and number 4 here?
        vehicle.changeOil()
        vehicle.washWindow()
    }

    fun oilChange(vehicle:Serviceable) {
        vehicle.changeOil()
    }

}
