package com.example.projet_memoir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Notofication extends AppCompatActivity {

    TextView reminde , admine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notofication);

        reminde = findViewById(R.id.remind);
        admine = findViewById(R.id.admin);

        reminde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notofication.this,pushnotif.class);
                startActivity(intent);

            }
        });

        admine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://firebase.google.com/");
            }
        });

    }
    @SuppressLint("MissingInflatedId")
    private  void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
    }