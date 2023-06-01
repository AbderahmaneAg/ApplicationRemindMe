package com.example.projet_memoir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContanctUsActivity extends AppCompatActivity {

    TextView mail , siteWeb , face , insta , tiwtter , watsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contanct_us);

        mail = findViewById(R.id.gmail);
        face = findViewById(R.id.fb);
        insta = findViewById(R.id.ig);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ContanctUsActivity.this,sendemail.class);
                startActivity(intent);

            }
        });

        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://facebook.google.com/");
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://instagram.google.com/");
            }
        });

    }
    @SuppressLint("MissingInflatedId")
    private  void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}