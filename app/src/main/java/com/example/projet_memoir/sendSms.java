package com.example.projet_memoir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sendSms extends AppCompatActivity {

    EditText editTextnumber , editTextmessage;
    Button SendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);



        editTextnumber = findViewById(R.id.edit_text_number);
        editTextmessage = findViewById(R.id.edit_text_messageSms);
        SendBtn = findViewById(R.id.button_sendSms);

        SendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check permission for premision
                if (ContextCompat.checkSelfPermission(sendSms.this, Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED){
                    // when permission is granted
                    // creat a method
                    sendSMS();
                }else {
                    // when permission is not granted
                    // request for permission
                    ActivityCompat.requestPermissions(sendSms.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }

            }


        });



    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // check condition
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            // permission  is granted
            // call method
            sendSMS();
        }
        else {
            // when permission  is denied
            // display toast msg
            Toast.makeText(this, "permission  denied", Toast.LENGTH_SHORT).show();
        }

    }

    private void sendSMS() {
        // get value from editText
        String phone = editTextnumber.getText().toString();
        String  message = editTextmessage.getText().toString();

        // chek condition if string is empty or not
        if (!phone.isEmpty() && !message.isEmpty()){
            // intialialize SMS manger
            SmsManager smsManager = SmsManager.getDefault();
            // send message
            smsManager.sendTextMessage(phone, null,message,null, null);
            // display Toast msg
            Toast.makeText(this, "SMS send successfull", Toast.LENGTH_SHORT).show();
        }
        else {
            // when string is empty then display toast msg
            Toast.makeText(this, "Please enter phone and message ", Toast.LENGTH_SHORT).show();
        }
    }
}