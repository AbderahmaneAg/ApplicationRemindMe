package com.example.projet_memoir;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CreatAccont extends AppCompatActivity {
    private EditText inputemail, inputpassword, retypePassword, fullName, address, number , mama,papa  ;
    private TextView dateBrth ;
    private Spinner gender , pmi ;
    private ProgressDialog pd;
    private FirebaseAuth mAuth;
    private DatabaseReference db_ref;
    private FirebaseDatabase db_User;
    private boolean isUpdate = false;
    private CheckBox isDonor;


    Button buttonReg;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://app-final-dc9ea-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_accont);
        mAuth = FirebaseAuth.getInstance();
        db_User = FirebaseDatabase.getInstance();
        db_ref = db_User.getReference("users");

        mAuth = FirebaseAuth.getInstance();


        inputemail = findViewById(R.id.email_edit_text);
        inputpassword = findViewById(R.id.password_edit_text);
        retypePassword = findViewById(R.id.confirm_password_edit_text);
        fullName = findViewById(R.id.Name_edit_text);
        gender = findViewById(R.id.gender_eit_text);
        address = findViewById(R.id.Adresse_eit_text);
        pmi = findViewById(R.id.piame_eit_text);
        number = findViewById(R.id.mobile_number_eit_text);
        mama = findViewById(R.id.mathername_eit_text);
        papa = findViewById(R.id.fathername_eit_text);
        dateBrth = findViewById(R.id.Date_eit_text);
        dateBrth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog1();
            }
        });
        buttonReg = findViewById(R.id.creat_accont_btn);


        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = inputemail.getText().toString();
                final String password = inputpassword.getText().toString();
                final String ConfirmPassword = retypePassword.getText().toString();
                final String Name = fullName.getText().toString();
                final int Gender = gender.getSelectedItemPosition();
                final String Contact = number.getText().toString();
                final String Address = address.getText().toString();
                final int Division = pmi.getSelectedItemPosition();
                final String div   = pmi.getSelectedItem().toString();
                final String matherName = mama.getText().toString();
                final String fatherName = papa.getText().toString();
                final String birthady = dateBrth.getText().toString();



                try {

                    if (Name.length() <= 2) {
                        ShowError("Name");
                        fullName.requestFocusFromTouch();
                    } else if (Contact.length() < 10) {
                        ShowError("Contact Number");
                        number.requestFocusFromTouch();
                    } else if (Address.length() <= 2) {
                        ShowError("Address");
                        address.requestFocusFromTouch();
                    } else {
                        if (!isUpdate) {
                            if (email.length() == 0) {
                                ShowError("Email ID");
                                inputemail.requestFocusFromTouch();
                            } else if (password.length() <= 5) {
                                ShowError("Password");
                                inputpassword.requestFocusFromTouch();
                            } else if (password.compareTo(ConfirmPassword) != 0) {
                                Toast.makeText(CreatAccont.this, "Password did not match!", Toast.LENGTH_LONG)
                                        .show();
                                retypePassword.requestFocusFromTouch();
                            } else {
                                registerUser( Name,  number,  address,  email, password);
                            }

                        }
                        //pd.dismiss();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void registerUser(String name, EditText contact, EditText address, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(CreatAccont.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        final String email = inputemail.getText().toString();
                        final String password = inputpassword.getText().toString();
                        final String ConfirmPassword = retypePassword.getText().toString();
                        final String Name = fullName.getText().toString();
                        final int Gender = gender.getSelectedItemPosition();
                        final String Address = address.getText().toString();
                        final int Division = pmi.getSelectedItemPosition();
                        final String Contact = number.getText().toString();
                        final String matherName = mama.getText().toString();
                        final String fatherName = papa.getText().toString();
                        final String birthady = dateBrth.getText().toString();

                        final String div   = pmi.getSelectedItem().toString();
                        if (!task.isSuccessful()) {
                            Toast.makeText(CreatAccont.this, "L'enregistrement a échoué, essayez a nouveau.", Toast.LENGTH_LONG)
                                    .show();
                            Log.v("error", task.getException().getMessage());
                        } else {
                            Toast.makeText(CreatAccont.this, "registere suucces",Toast.LENGTH_LONG).show();
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            firebaseUser.sendEmailVerification();

                            String id = mAuth.getCurrentUser().getUid();
                            db_ref.child(id).child("Name").setValue(Name);
                            db_ref.child(id).child("Email").setValue(email);
                            db_ref.child(id).child("Password").setValue(password);
                            db_ref.child(id).child("Gender").setValue(Gender);
                            db_ref.child(id).child("PMI").setValue(Division);
                            db_ref.child(id).child("adresse").setValue(Address);
                            db_ref.child(id).child("number").setValue(Contact);
                            db_ref.child(id).child("Mather Name").setValue(matherName);
                            db_ref.child(id).child("Father Name").setValue(fatherName);
                            db_ref.child(id).child("Date of birth").setValue(birthady);


                            Toast.makeText(getApplicationContext(), "Votre compte a ete creé!", Toast.LENGTH_LONG)
                                    .show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);


                        }
                        //pd.dismiss();

                    }

                });
    }

    private void ShowError(String error) {

        Toast.makeText(CreatAccont.this, "Please, Enter a valid "+error,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void openDialog1(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                dateBrth.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        } , 2023, 1,15);

        dialog.show();
    }
}