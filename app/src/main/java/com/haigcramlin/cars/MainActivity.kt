package com.haigcramlin.cars

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customList = listOf("Ferrari Testarosa", "Honda Speedwagon", "Honda Civic", "Ford Fiesta")

        val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        val adapter2 = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)

        choose_car.adapter = adapter
        choose_car2.adapter = adapter2

        choose_car.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var one = adapterView?.getItemAtPosition(position).toString()
                choose_car2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        adapterView: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        var two = adapterView?.getItemAtPosition(position).toString()
                        Toast.makeText(this@MainActivity,
                            "Racer 2 selects: ${adapterView?.getItemAtPosition(position).toString()}",
                            Toast.LENGTH_LONG).show()



                        button.setOnClickListener {
                            var randomNumb = Math.round(Math.random() * 10)
                            var winCar:String? = null
                            var loseCar:String? = null

                            if(randomNumb <= 5){
                                winCar = one
                                loseCar = two
                            } else {
                                winCar = two
                                loseCar = one
                            }
                            textView.text = ("${winCar} wins!")
                        }
                    }
                }
                Toast.makeText(this@MainActivity,
                    "Racer 1 selects: ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG).show()
            }
        }
        choose_car2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var one = adapterView?.getItemAtPosition(position).toString()
                choose_car.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        adapterView: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        var two = adapterView?.getItemAtPosition(position).toString()
                        Toast.makeText(this@MainActivity,
                            "Racer 1 selects: ${adapterView?.getItemAtPosition(position).toString()}",
                            Toast.LENGTH_LONG).show()



                        button.setOnClickListener {
                            var randomNumb = Math.round(Math.random() * 10)
                            var winCar:String? = null
                            var loseCar:String? = null

                            if(randomNumb <= 5){
                                winCar = one
                                loseCar = two
                            } else {
                                winCar = two
                                loseCar = one
                            }
                            textView.text = ("${winCar} wins!")
                        }
                    }
                }
                Toast.makeText(this@MainActivity,
                    "Racer 2 selects: ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG).show()
                 button.setOnClickListener {
                    textView.text = ("${adapterView?.getItemAtPosition(position).toString()}")
                }
            }
        }


        val ferrari = Car("ferrari", "testarossa")
        val honda = Car("honda", "speed wagon")
        val honda2 = Car("honda", "civic")
        val speed500 = Racetrack("SPEED500")
        val radiatorSprings = Racetrack("Radiator Springs")
        val leader = LeaderBoard()
        val ford = Car("ford", "fiesta")
        val chevy = Car("corvette", "stingray")

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


}