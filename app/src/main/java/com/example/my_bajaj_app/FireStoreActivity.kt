package com.example.my_bajaj_app

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class FireStoreActivity : AppCompatActivity() {

    var TAG:String = FireStoreActivity::class.java.simpleName
    lateinit var titleEditText: EditText
    lateinit var notesEditText: EditText
    lateinit var db: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_store)
        db = Firebase.firestore
        titleEditText = findViewById(R.id.etTitle)
        notesEditText = findViewById(R.id.etNotes)
    }

    fun firestoreHandler(view: android.view.View) {
        when(view.id){
            R.id.btn_fssend ->{
                sendDatatoFs()
            }
            R.id.btn_fsget -> {
                getDataFs()
            }
        }
    }

    private fun getDataFs() {
        db.collection("notes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data} here")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    private fun sendDatatoFs() {
        var title = titleEditText.text.toString()
        var notes = notesEditText.text.toString()
        val note = hashMapOf(
            "title" to title,
            "note" to notes,
        )

        // Add a new document with a generated ID
        db.collection("notes")
            .add(note)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }
}