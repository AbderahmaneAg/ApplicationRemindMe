package com.example.projet_memoir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class codepm extends AppCompatActivity {

    Button Enter;
    EditText code1 ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codepm);


        String code = "remindMeApp";
        Enter = findViewById(R.id.okBtn);
        code1 = findViewById(R.id.code_edit_text);

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = code1.getText().toString();
                if (email.equals(code)){
                    startActivity(new Intent(codepm.this,Notofication.class));
                }
                else  {
                    Toast.makeText(getApplicationContext(), "code incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        }
  }