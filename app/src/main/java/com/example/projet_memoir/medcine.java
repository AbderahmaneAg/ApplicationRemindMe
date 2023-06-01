package com.example.projet_memoir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class medcine extends AppCompatActivity {

    EditText Age, Taille, Poid ,Date,Mark;
    Button ajouter ;

    private DatabaseReference db_ref;
    private FirebaseDatabase db_User;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://app-final-dc9ea-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medcine);
        db_User = FirebaseDatabase.getInstance();
        db_ref = db_User.getReference("Surveillance");

        Age=findViewById(R.id.age);
        Taille=findViewById(R.id.taille);
        Poid=findViewById(R.id.poid);
        Date=findViewById(R.id.date);
        Mark=findViewById(R.id.mark);

        ajouter=findViewById(R.id.ajouterBtn);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),surveillance.class);
                i.putExtra("age", Age.getText().toString());
                i.putExtra("taille",Taille.getText().toString());
                i.putExtra("poid",Poid.getText().toString());
                i.putExtra("date",Date.getText().toString());
                i.putExtra("mark",Mark.getText().toString());
                startActivity(i);

                final String age = Age.getText().toString();
                final String taille = Taille.getText().toString();
                final String poid = Poid.getText().toString();
                final String date = Date.getText().toString();
                final String mark = Mark.getText().toString();

                DatabaseReference userRef = db_ref.push(); // Generate a unique key for the user
                userRef.child("Age").setValue(age);
                userRef.child("Taille").setValue(taille);
                userRef.child("Poid").setValue(poid);
                userRef.child("Date").setValue(date);
                userRef.child("Mark").setValue(mark);

                Toast.makeText(getApplicationContext(), "Data saved successfully!", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), surveillance.class);
                startActivity(intent);
            }
        });

    }
    }