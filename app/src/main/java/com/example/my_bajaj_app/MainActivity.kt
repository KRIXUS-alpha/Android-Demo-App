package com.example.my_bajaj_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name = intent.extras?.getString("krix")
        var tvMain =  findViewById<TextView>(R.id.tvMain)
        tvMain.text = name
    }

    fun clickHandler(view: View) {
        Toast.makeText(this, "Starting and Routing to Home Activity", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, HomeActivity::class.java))

    }

    fun clickHandlerJava(view: View) {
        Toast.makeText(this, "Starting and Routing to Java Activity", Toast.LENGTH_SHORT).show()
//        startActivity(Intent(this,JavaActivity::class.java)) // quick way to start activity
        var mIntent:Intent
        mIntent = Intent(this, JavaActivity::class.java)
        mIntent.putExtra("KRIX","KRIXUS")
        startActivity(mIntent)
    }
}