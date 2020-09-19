package com.haigcramlin.cars

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // FTW

        //Main Activity is our main entry to the android application. We can think of onCreate as main() for now
        //It is just that, when the MainActivity has been created this function is called.
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

        //val btnClickMe = findViewById(R.id.button) as Button
        // var myTextView = findViewById(R.id.textView) as TextView
        var timesClicked = 0
        button.setOnClickListener {
            timesClicked += 1
            textView.text = timesClicked.toString()
            Toast.makeText(this@MainActivity, "Racing", Toast.LENGTH_SHORT).show()
        }
    }


}