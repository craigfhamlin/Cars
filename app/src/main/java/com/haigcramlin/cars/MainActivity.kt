package com.haigcramlin.cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var car1: String? = null
    var car2: String? = null
    var winnerImage: ImageView? = null
    var trophyImage: ImageView? = null
    var trophyImage2: ImageView? = null
    var removeCarImage: ImageView? = null
    var someCars: List<String?> = arrayListOf(car1, car2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trophyImage = findViewById(R.id.blank_trophy)
        trophyImage2 = findViewById(R.id.blank_trophy2)
        winnerImage = findViewById(R.id.blank_winner)
        removeCarImage = findViewById(R.id.cars_blank)
        createCarsAndTracks()
        setUpSpinners()
        setUpButton()

    }

    fun setUpSpinners() {
        val customList = listOf("Ferrari Testarosa", "Honda Speedwagon", "Honda Civic", "Ford Fiesta")
        var adapter =
            ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        var adapter2 =
            ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        choose_car.adapter = adapter
        choose_car2.adapter = adapter2
        choose_car.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                 car1 = adapterView?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@MainActivity,
                    "Racer 1 selects: ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        choose_car2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                car2 = adapterView?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@MainActivity,
                    "Racer 2 selects: ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
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
        button.setOnClickListener {
            raceSelectedCars()
        }
    }

    fun addSpinnerListener(spinner:Spinner, isCar1: Boolean) {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long)  {
                if(isCar1)
                    car1 = adapterView?.getItemAtPosition(position).toString()
                else
                    car2 = adapterView?.getItemAtPosition(position).toString()
                var homey: List<String> = arrayListOf(car1.toString(), car2.toString())

            }
        }
    }

    fun createCars() {

    }

    fun getCarlist() {

    }

    fun drawableResource(winner: String?) {
        var drawableResource =
        when (winner) {
            // "Ferrari Testarosa", "Honda Speedwagon", "Honda Civic", "Ford Fiesta"
            "Ferrari Testarosa" -> R.drawable.ferarri_testarossa
            "Honda Speedwagon" -> R.drawable.honda_speedwagon
            "Honda Civic" -> R.drawable.honda_civic
            else -> R.drawable.ford_fiesta
        }
        winnerImage?.setImageResource(drawableResource)
        trophyImage?.setImageResource(R.drawable.trophy)
        trophyImage2?.setImageResource(R.drawable.trophy)
        removeCarImage?.setImageResource(R.drawable.blank)
    }
    fun raceSelectedCars() {
        //get selected car from 1
        //get selected car from 2

        var randomNumb = Math.round(Math.random() * 10)
        var winner: String? = null

        if (randomNumb <= 5) {
            textView.text = ("${car1} wins!")
            winner = car1
            drawableResource(winner)

        } else {
            textView.text = ("${car2} wins!")
            winner = car2
            drawableResource(winner)
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
        val tim = listOf(winner1[0], winner2[0])
}

 */