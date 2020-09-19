package com.haigcramlin.cars

data class LeaderBoardEntry(val car : Car, var points: Int)

class LeaderBoard() {
    var leaderBoardEntries: MutableList<LeaderBoardEntry> = mutableListOf()

    fun acceptRandomListCars(newCarList: MutableList<Car> ) {
        newCarList.removeAt(0)
        this.addLeaderBoardEntry(newCarList)
    }

    fun addLeaderBoardEntry(newCarList: MutableList<Car>): MutableList<LeaderBoardEntry> {
        newCarList.forEach{
            var newCar = it
            leaderBoardEntries.add(LeaderBoardEntry(newCar, 0))
        }
        return leaderBoardEntries
    }

    fun updateWinner(winner: List<Car>, track: String) {
        var w1 = winner.elementAt(0)
        var l1 = winner.elementAt(1)

        for (i in leaderBoardEntries){
            if (i.car == w1){
                i.points += 5
            }
        }
        this.printRaceResults(track, w1, l1)
        this.updated()
    }

    fun printRaceResults(track: String, w1: Car, l1: Car) {
        println("  ***$track RACE RESULTS***")
        println("     Place        Car")
        println("       1    ${w1.make} ${w1.model} ")
        println("       2    ${l1.make} ${l1.model} ")
        println("${w1.make} ${w1.model} won er and got 5 added")
    }

    fun updated() {
        leaderBoardEntries.sortByDescending {it.points}
        println("      ***OVERALL STANDINGS***")

        leaderBoardEntries.forEach {
            var z = it.car
            println("Car: ${z.make} ${z.model} Races: ${it.car.races} Points: ${it.points}")
        }
    }
}