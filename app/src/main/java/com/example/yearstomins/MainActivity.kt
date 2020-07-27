package com.example.yearstomins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_to_calc = findViewById<Button>(R.id.calc_btn) as Button

        btn_to_calc.setOnClickListener{
            Toast.makeText(this@MainActivity, "Calculation Complete", Toast.LENGTH_SHORT).show()

        }

    }
}
