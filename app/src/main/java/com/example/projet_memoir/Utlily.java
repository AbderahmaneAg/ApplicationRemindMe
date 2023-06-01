package com.example.projet_memoir;

import android.content.Context;
import android.widget.Toast;

public class Utlily {

    static  void showToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT ).show();
    }

}
