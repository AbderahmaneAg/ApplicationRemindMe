package com.example.projet_memoir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText emailEditText,passwordEditText;
    Button LoginBtn;
    ProgressBar progressBar;
    TextView CreatAccontBtnTextView;
    TextView firebasesite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        LoginBtn = findViewById(R.id.login_btn);
        progressBar = findViewById(R.id.progress_bar);
        CreatAccontBtnTextView = findViewById(R.id.creat_text_view);

        LoginBtn.setOnClickListener((v) -> LoginUser());
        CreatAccontBtnTextView.setOnClickListener((v) -> startActivity(new Intent(Login.this, CreatAccont.class)));

        firebasesite = findViewById(R.id.personMedc_text_view);

        firebasesite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this,codepm.class);
                startActivity(intent);

            }
        });

    }


    void LoginUser (){

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean isvalidated = ValidateData(email,password);
        if (!isvalidated) {
            return;
        }

        loginAccontInFireBase(email,password);

    }


    void loginAccontInFireBase(String email,String password){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        chngeInProgresse(true);
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                chngeInProgresse(false);
                if (task.isSuccessful()){
                    //log in is success
                    if (firebaseAuth.getCurrentUser().isEmailVerified()){
                        //go to mainactivity
                        startActivity(new Intent(Login.this,HomePage.class));
                        finish();
                    }else {
                        Utlily.showToast(Login.this, "Email not veriifed , please verify your email ");
                    }

                }else {
                    //log in faild
                    Utlily.showToast(Login.this, task.getException().getLocalizedMessage());
                }

            }
        });

    }


    void  chngeInProgresse (boolean inProgress) {
        if (inProgress) {
            progressBar.setVisibility(View.VISIBLE);
            LoginBtn.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            LoginBtn.setVisibility(View.VISIBLE);
        }
    }

    boolean ValidateData (String email, String password ) {
        //validate the data that are input by user.


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Email is invalid");
            return false;
        }

        if (password.length() < 6) {
            passwordEditText.setError("Passwod length is invalid");
            return false;
        }

        return true;
    }





}