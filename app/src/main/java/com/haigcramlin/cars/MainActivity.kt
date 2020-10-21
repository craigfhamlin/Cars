package com.haigcramlin.cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var car1:String? = null
    var car2:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createCarsAndTracks()

        setUpButton()
        setUpSpinners()
    }

    fun createCarsAndTracks() {
        val ferrari = Car("ferrari", "testarossa")
        val honda = Car("honda", "speed wagon")
        val honda2 = Car("honda", "civic")
        val ford = Car("ford", "fiesta")
        val chevy = Car("corvette", "stingray")

        val speed500 = Racetrack("SPEED500")
        val radiatorSprings = Racetrack("Radiator Springs")
        val leader = LeaderBoard()
    }

    fun setUpButton() {
        race_button.setOnClickListener {
            raceSelectedCars()
        }
    }

    fun raceSelectedCars() {
        Log.d("SHANE", "raceSelectedCars: ClickButton $car1 $car2")
        //get selected car from 1
        //get selected car from 2
        //race
        //write race code
    }

    fun setUpSpinners() {
        val customList = listOf("Ferrari Testarosa", "Honda Speedwagon", "Honda Civic", "Ford Fiesta")

        var adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        var adapter2 = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)

        choose_car.adapter = adapter
        choose_car2.adapter = adapter2

        choose_car.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                car1 = adapterView?.getItemAtPosition(position).toString()
            }
        }

        choose_car2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                car2 = adapterView?.getItemAtPosition(position).toString()
            }
        }
    }

    fun getCarList() : List<String> {
        val gimmeCars = GimmeCars()
        val cars = gimmeCars.makeCars()

        val carNames = mutableListOf<String>()
        for (car in cars) {
            carNames.add(car.name)
        }
        return if(carNames.size > 0) carNames else listOf("Ferrari Testarosa", "Honda Speedwagon", "Honda Civic", "Ford Fiesta")
    }

    fun addSpinnerListener(spinner:Spinner, isCar1: Boolean) {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.d("SHANE", "onItemSelected: $spinner $isCar1 ${adapterView?.getItemAtPosition(position).toString()}")
                if(isCar1)
                    car1 = adapterView?.getItemAtPosition(position).toString()
                else
                    car2 = adapterView?.getItemAtPosition(position).toString()
            }
        }
    }
}


/*
        leader.addLeaderBoardEntry(mutableListOf(ford, honda, ferrari, honda2, chevy))
        var gimme = GimmeCars()
        leader.acceptRandomListCars(gimme.makeCars())
        val winner1 = speed500.race(ferrari, honda)
        leader.updateWinner(winner1, "SPEED500")
        val winner2 = radiatorSprings.race(ford, honda2)
        leader.updateWinner(winner2, "RADIATOR SPRINGS")
        speed500.race(gimme.makeCars())
        val tim = listOf(winner1[0], winner2[0])*/
