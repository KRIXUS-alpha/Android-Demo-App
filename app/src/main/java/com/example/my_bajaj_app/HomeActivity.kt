package com.example.my_bajaj_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    lateinit var etContact: EditText
    lateinit var etEmail: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        etContact = findViewById(R.id.etContact)
        etEmail = findViewById(R.id.etEmail)
    }

    fun handleClick(view: View) {
        when(view.id){
            R.id.startMain -> startMainAct()
            R.id.call101-> startDialer()
        }


    }

    override fun onPause() {
        super.onPause()
        storeState();
    }

    //view-tool windows-file exploreer-com.example.my_bajaj_app.data/com.example.my_bajaj_app.data/yourpackage/sharedprefs/filename
    private fun storeState() {
        //get the com.example.my_bajaj_app.data from the edittext
        var contact: String = etContact.text.toString()
        var email = etEmail.text.toString()
        //create file home_state_prefs
        var sharedPreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE)
        //open the file in edit mode
        var editor = sharedPreferences.edit()
        //write the com.example.my_bajaj_app.data to the file
        editor.putString("cont",contact)
        editor.putString("eml",email)
        //save the file
        editor.apply() //appply is asynchronous
    }


    override fun onResume() {
        super.onResume()
        restoreState();
    }


    private fun restoreState() {
        //open the file home_state
        var sharedPreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE)
        //read the com.example.my_bajaj_app.data from the file
        var contact = sharedPreferences.getString("cont","")
        var email = sharedPreferences.getString("eml","")
        //set the com.example.my_bajaj_app.data into the edittexts
        etContact.setText(contact)
        etEmail.setText(email)
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