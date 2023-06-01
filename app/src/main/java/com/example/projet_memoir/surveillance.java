package com.example.projet_memoir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.errorprone.annotations.Var;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class surveillance extends AppCompatActivity {

    ListView liste;
    String age,taille,poid,date,mark;
    HashMap<String,String> map;
    params p=new params();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveillance);


        liste=findViewById(R.id.lst);

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            age=extras.getString("age");
            taille=extras.getString("taille");
            poid=extras.getString("poid");
            date=extras.getString("date");
            mark=extras.getString("mark");
            map=new HashMap<String , String>();
            map.put("age" ,age);
            map.put("taille",taille);
            map.put("poid",poid);
            map.put("date",date);
            map.put("mark",mark);
            p.valeus.add(map);
        }

        SimpleAdapter Adapter = new SimpleAdapter(surveillance.this,p.valeus,R.layout.activity_item,
                new String[]{"age","taille","poid","date","mark"},
                new  int[]{R.id.age,R.id.taille,R.id.poid,R.id.date,R.id.mark}
        );
        liste.setAdapter(Adapter);

    }
}