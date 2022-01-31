package com.example.my_bajaj_app

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class ContactsContentProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_content_provider)


        val uriContact: Uri = ContactsContract.Contacts.CONTENT_URI//        check for permission to access sms

        val dataCursor: Cursor = getContentResolver()
            .query(uriContact,null,null,null,null)!!

        var from = arrayOf("display_name","")
        var to = intArrayOf(android.R.id.text1,android.R.id.text2)
        var adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2,
            dataCursor ,from,to)

        var cpListView: ListView = findViewById(R.id.cpListview)
        cpListView.adapter = adapter
    }
}