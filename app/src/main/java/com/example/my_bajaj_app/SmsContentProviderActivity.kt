package com.example.my_bajaj_app

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class SmsContentProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        val uriSms: Uri= Uri.parse("content://sms/inbox")
//        check for permission to access sms

        val dataCursor: Cursor = getContentResolver()
            .query(uriSms,null,null,null,null)!!

        var from = arrayOf("body")
        var to = intArrayOf(android.R.id.text1)
        var adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_1,
            dataCursor ,from,to)

        var cpListView: ListView = findViewById(R.id.cpListview)
        cpListView.adapter = adapter




    }
}