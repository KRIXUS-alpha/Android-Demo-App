package com.example.my_bajaj_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun handleClick(view: View) {
//        kotlin says that you cant have a variable as null, billion dollar , null pointer exceptions
        var intent = Intent(this, MainActivity::class.java) // no need for new keyword

        startActivity(intent)

        Toast.makeText(this, "Starting and routing to MainActivity", Toast.LENGTH_SHORT).show()
    }
}