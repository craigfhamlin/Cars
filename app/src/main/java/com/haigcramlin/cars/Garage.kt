package com.haigcramlin.cars

interface VehicleForGarage  {
    var vehicle: String
    fun chooseCar () : Car
    fun chooseTruck (): Truck
}  // think of as brochure that lists what garage can service (1. car, 2. truck)

class Garage: VehicleForGarage {
    override var vehicle: String = "test vehicle"
    override fun chooseCar(): Car{
        TODO("Not yet implemented")
    }

    override fun chooseTruck(): Truck {
        TODO("Not yet implemented")
    }

    fun changeTires() = Unit

    fun changeOil(){

    }

    fun serviceTruckEngine(){

    }

}

