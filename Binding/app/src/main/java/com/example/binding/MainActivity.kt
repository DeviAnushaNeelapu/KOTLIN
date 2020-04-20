package com.example.binding
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.binding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var databinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        databinding.setBtn.setOnClickListener { setName() }
    }

    private fun setName() {
        val n = databinding.name.text.toString()
        /*databinding.displayName.text = n*/
        val d = Name(n)
        databinding.n = d
        databinding.name.text.clear()
    }
}
