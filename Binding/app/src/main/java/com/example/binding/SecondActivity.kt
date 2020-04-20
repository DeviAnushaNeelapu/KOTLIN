package com.example.binding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.binding.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity() {
    lateinit var databinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}
