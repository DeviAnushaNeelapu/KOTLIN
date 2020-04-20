package com.example.catfacts

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var result:TextView
    val LINK :String="https://cat-fact.herokuapp.com/facts"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result=findViewById(R.id.result)
        val btn=findViewById<Button>(R.id.fetch_btn)
        btn.setOnClickListener {
            fetchCatFacts(this,result).execute(LINK)
        }

    }

    class  fetchCatFacts(val context: Context, val  result :TextView): AsyncTask<String, Void, String>() {
        val link=""
        override fun doInBackground(vararg params: String?): String {
            // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val LINK=params[0]
            //   val uri= Uri.parse(LINK)
            val url= URL(LINK)
            val httpsUrlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            val inpustreem: InputStream =httpsUrlConnection.inputStream
            // val br:BufferedReader= BufferedReader(InputStreamReader(inpustreem))
            val text=inpustreem.bufferedReader().use(BufferedReader::readText)
            return text


        }
        //parse the json data
        override fun onPostExecute(r: String?) {
            super.onPostExecute(r)
            result.text=r
        }


    }
}
