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

public class MainActivity extends AppCompatActivity {

    Button btnCall;
    Button btnSend;
    Intent intent;
    private static final int REQUEST_SEND_SMS = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnSend = findViewById(R.id.btnSend);
    }

    public void callOrSendMethod(View view) {
        switch (view.getId()) {
            case R.id.btnCall:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+7 (495) 152-55-28"));
                startActivity(intent);
                break;

            case R.id.btnSend:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SEND_SMS);
                } else{
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage("+79101234567",null,"Привет",null,null);
                }
        }

//                intent = new Intent(Intent.ACTION_SENDTO);
//                intent.setData(Uri.parse("smsto:+79101234567"));
//                intent.putExtra("sms_body", "sms text");
//                startActivity(intent);
//                break;
        }
    }

