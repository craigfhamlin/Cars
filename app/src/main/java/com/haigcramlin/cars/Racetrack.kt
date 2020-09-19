package com.haigcramlin.cars

class Racetrack(val name: String){

    init{
        println("Congratulations: You have just created the ${name} racetrack")
    }

    fun race(car1: Car, car2: Car): List<Car> {
        println("${car1.make} ${car1.model} and ${car2.make} ${car2.model} do battle at ${this.name}!!")
        val randomNumber = Math.round(Math.random() * 10)
        var winningCar:Car? = null
        var losingCar:Car? = null

        if(randomNumber <= 5){
            winningCar = car1
            losingCar = car2
        } else {
            winningCar = car2
            losingCar = car1
        }

        car1.races++
        car2.races++
        var result = listOf(winningCar, losingCar)
        return result
    }

    fun race(newCarList: MutableList<Car>):  List<Car> {
        var winningCar:Car? = null
        var losingCar:Car? = null
        var f = Car("loser", "machine")
        winningCar = f
        for (i in 1..100) {
            var randomNumber = Math.round(Math.random() * 100)
            var gord = randomNumber.toInt()
            var bo = 0

            newCarList.forEach {
                var car = it.model
                var cars = car.removeRange(0, 2)
                var gerry = cars.toInt()
                // winningCar = it
                //   println("${winningCar.make} ${winningCar.model}")

                if (gerry == gord) {
                    println("car # ${gerry} matched")
                    bo = i
                    var winner: Car = it
                    //  winningCar = winner
                    println("${winningCar.make} ${winningCar.model} won er")
                    println("${it.make} ${it.model} won er")
                    println("${winner.make} ${winner.model} won er")


                }
            }
            if (i == bo) {
                println("${winningCar.make} ${winningCar.model} won er")
                break
            }
        }
        println("${winningCar.make} ${winningCar.model} won er")
        var result = listOf(winningCar, losingCar)
        var randomRacerResults = newCarList
        return randomRacerResults
    }
}
