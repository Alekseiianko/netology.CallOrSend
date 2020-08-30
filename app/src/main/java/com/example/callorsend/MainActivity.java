package com.example.callorsend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnCall;
    Button btnSend;
    Intent intent;
    EditText phoneNumber;
    EditText message;
    String phone;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnSend = findViewById(R.id.btnSend);
        phoneNumber = findViewById(R.id.phoneNumber);
        message = findViewById(R.id.message);
    }

    public void callOrSendMethod(View view) {
        phone = phoneNumber.getText().toString().trim();
        text = message.getText().toString();
        switch (view.getId()) {
            case R.id.btnCall:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phone));
                startActivity(intent);
                break;

            case R.id.btnSend:
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + phone));
                intent.putExtra("sms_body", text);
                startActivity(intent);
                break;
        }
    }
}

