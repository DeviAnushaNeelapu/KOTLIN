package com.example.calendarapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun addEvent(view: View) {
        val event =findViewById<EditText>(R.id.event)
        val c : Calendar = Calendar.getInstance()
        val intent = Intent(Intent.ACTION_EDIT)
        intent.setType("vnd.android.cursor.item/event")
        intent.putExtra("beginTime",c.timeInMillis)
        intent.putExtra("endTime",c.timeInMillis+60+60+1000)
        /*For Add Event Static*/
        //intent.putExtra("title","Birthday")
        /*For Add Event Dynamically*/
        intent.putExtra("title",event.text.toString())
        startActivity(intent)
    }
}
