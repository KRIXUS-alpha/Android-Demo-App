package com.example.my_bajaj_app;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class JavaActivity   extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        // extracting passed extra data
        String name = getIntent().getExtras().getString("KRIX");
        TextView mTextView = findViewById(R.id.tvMain);
        mTextView.setText(name);
    }

    public void clickHandler(View view) {
        Toast.makeText(this, "loggin in", Toast.LENGTH_SHORT).show();
        Intent mIntent;
        mIntent  = new Intent(JavaActivity.this,MainActivity.class);
        mIntent.putExtra("krix","krixus"); // adding data to be passed b/n activities
        startActivity(mIntent);

    }
}
