package com.example.projet_memoir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.Constants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class vaccinations extends AppCompatActivity {

     TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16 ,mm;

    Button saveBtn;


    private FirebaseDatabase database ;
    private DatabaseReference myRef ;
   // String getnom;
    private void getView() {
            t1=findViewById(R.id.vaccin01);
            t2=findViewById(R.id.vaccin02);
            t3=findViewById(R.id.vaccin03);

                            }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccinations);
        getView();


        database  = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        saveBtn = findViewById(R.id.saveBtn);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String BCG = t1.getText().toString();
                final String vaccin02 = t2.getText().toString();
                final String vaccin03 = t3.getText().toString();
                final String vaccin04 = t4.getText().toString();
                final String vaccin05 = t5.getText().toString();
                final String vaccin06 = t6.getText().toString();
                final String vaccin07 = t7.getText().toString();
                final String vaccin08 = t8.getText().toString();
                final String vaccin09 = t9.getText().toString();
                final String vaccin10 = t10.getText().toString();
                final String vaccin11 = t11.getText().toString();
                final String vaccin12 = t12.getText().toString();
                final String vaccin13 = t13.getText().toString();
                final String vaccin14 = t14.getText().toString();
                final String vaccin15 = t15.getText().toString();
                final String vaccin16 = t16.getText().toString();

                // Add the remaining textviews for other vaccinations

                DatabaseReference vaccinationRef = myRef.child("vaccinations").push();
                vaccinationRef.child("BCG").setValue(BCG);
                vaccinationRef.child("HBV(1)").setValue(vaccin02);
                vaccinationRef.child("HBV(2)").setValue(vaccin03);
                vaccinationRef.child("DTC(1)").setValue(vaccin04);
                vaccinationRef.child("HIB(1)").setValue(vaccin05);
                vaccinationRef.child("DTC(2)").setValue(vaccin06);
                vaccinationRef.child("HIB(2)").setValue(vaccin07);
                vaccinationRef.child("vDTC(3)").setValue(vaccin08);
                vaccinationRef.child("HIB(3)").setValue(vaccin09);
                vaccinationRef.child("HBV(3)").setValue(vaccin10);
                vaccinationRef.child("vANTI ROUGEOLE").setValue(vaccin11);
                vaccinationRef.child("DTC(4)").setValue(vaccin12);
                vaccinationRef.child("HIB(4)").setValue(vaccin13);
                vaccinationRef.child("DT").setValue(vaccin14);
                vaccinationRef.child("DT PPLIO 1").setValue(vaccin15);
                vaccinationRef.child("DT PPLIO 2").setValue(vaccin16);
                // Add the remaining vaccinations to the database

                Toast.makeText(getApplicationContext(), "Data saved successfully!", Toast.LENGTH_LONG).show();

            }
        });



        // button date
        t1=findViewById(R.id.vaccin01);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog1();
            }
        });
        t2=findViewById(R.id.vaccin02);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog2();
            }
        });
        t3=findViewById(R.id.vaccin03);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog3();
            }
        });
        t4=findViewById(R.id.vaccin04);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog4();
            }
        });
        t5=findViewById(R.id.vaccin05);
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog5();
            }
        });
        t6=findViewById(R.id.vaccin06);
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog6();
            }
        });
        t7=findViewById(R.id.vaccin07);
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog7();
            }
        });
        t8=findViewById(R.id.vaccin08);
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog8();
            }
        });
        t9=findViewById(R.id.vaccin09);
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog9();
            }
        });
        t10=findViewById(R.id.vaccin10);
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog10();
            }
        });
        t11=findViewById(R.id.vaccin11);
        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog11();
            }
        });
        t12=findViewById(R.id.vaccin12);
        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog12();
            }
        });
        t13=findViewById(R.id.vaccin13);
        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog13();
            }
        });
        t14=findViewById(R.id.vaccin14);
        t14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog14();
            }
        });
        t15=findViewById(R.id.vaccin15);
        t15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog15();
            }
        });
        t16=findViewById(R.id.vaccin16);
        t16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog16();
            }
        });



    }


        // methode clandrie
    private void openDialog1(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t1.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog2(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t2.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog3(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t3.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog4(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t4.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog5(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t5.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog6(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t6.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog7(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t7.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog8(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t8.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog9(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t9.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog10(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t10.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog11(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t11.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog12(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t12.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog13(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t13.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog14(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t14.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog15(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t15.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
    private void openDialog16(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                t16.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }


}