package com.haigcramlin.cars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResultActivity : AppCompatActivity() {
    lateinit var buttonGoToMain: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        buttonGoToMain = findViewById(R.id.Return1)
        buttonGoToMain.setOnClickListener {
            val intent2: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent2)
        }
    }
}