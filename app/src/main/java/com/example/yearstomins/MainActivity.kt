package com.example.yearstomins

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.Month
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calc_btn.setOnClickListener{view->
            val result = clickDatePicker(view)
            Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_SHORT).show()

        }

    }

    fun clickDatePicker(view: View){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                view, selectedYear, selectedMonth, selectedDay ->


            tvSelectedDate.text = "$selectedDay/${1 + selectedMonth}/$selectedYear"


            val yearToMins: Long = ((selectedYear)*525950).toLong()
            val MonthToMins: Long = ((view.month - selectedMonth)*43830).toLong()
            val dayToMins: Long = ((view.dayOfMonth - selectedDay)*41440).toLong()

            minutes.text = (yearToMins + MonthToMins + dayToMins).toString()
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val finalDate = sdf.parse(tvSelectedDate)

        }, year, month, day).show()


    }
}
