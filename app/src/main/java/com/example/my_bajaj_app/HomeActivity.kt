package com.example.my_bajaj_app

import android.content.Intent
import android.net.Uri
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
        when(view.id){
            R.id.startMain -> startMainAct()
            R.id.call101-> startDialer()
        }


    }

    private fun startDialer(){
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:191"))
        startActivity(dialIntent)
    }

    private fun startMainAct() {
        //        kotlin says that you cant have a variable as null, billion dollar , null pointer exceptions
        var intent = Intent(this, MainActivity::class.java) // no need for new keyword

        startActivity(intent)

        Toast.makeText(this, "Starting and routing to MainActivity", Toast.LENGTH_SHORT).show()
    }
}