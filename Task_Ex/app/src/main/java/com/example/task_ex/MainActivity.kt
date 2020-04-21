package com.example.task_ex

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    lateinit var result : TextView
    val LINK : String = https://github.com/LearnWebCode/json-example/blob/master/animals-1.json
    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.result)
        val btn = findViewById<Button>(R.id.fetch_btn)
        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.GONE

        btn.setOnClickListener {
            /*fetchCatFacts(result).execute(LINK)*/
            progressBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                fetchCatFacts()
            }
        }


    }

    suspend fun fetchCatFacts(){
        /*Run this code in a background thread - UI Should'nt be accessed*/
        val url = URL(LINK)
        val httpsURLConnection : HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream : InputStream = httpsURLConnection.inputStream
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            setValueOnResult(text)
        }
    }

    private fun setValueOnResult(text: String) {
        progressBar.visibility = View.GONE
        result.text = text
    }

}