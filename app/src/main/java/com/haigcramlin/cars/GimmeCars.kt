package com.haigcramlin.cars

class GimmeCars(){
    fun makeCars(): MutableList<Car> {
        var newCars = (10..99).shuffled().take(6)
        var newCarList: MutableList<Car> = mutableListOf()

        for (i in newCars) {
            var newCar = Car("racer", "# $i")
            newCarList.add(newCar)
        }
        return newCarList
    }
}