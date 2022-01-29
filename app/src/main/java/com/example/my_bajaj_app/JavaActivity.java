package com.example.my_bajaj_app;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
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
        switch (view.getId()){
            case R.id.btnAlarm:
                createAlarm("Alarm through intent",15,00);
                break;
            case R.id.btnKotAct:
                startMainActWData();
                break;
        }

    }
    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void startMainActWData() {
        Toast.makeText(this, "loggin in", Toast.LENGTH_SHORT).show();
        Intent mIntent;
        mIntent  = new Intent(JavaActivity.this,MainActivity.class);
        mIntent.putExtra("krix","krixus"); // adding data to be passed b/n activities
        startActivity(mIntent);
    }
}
