package com.example.my_bajaj_app

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
        Toast.makeText(this, "Sending", Toast.LENGTH_SHORT).show()
    }
}