package com.example.projet_memoir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;
    Button sms ,email;

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        textView =findViewById(R.id.Date_vaccin_text_view);
        textView2=findViewById(R.id.ChildSupervision);
        textView3=findViewById(R.id.Advices);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomePage.this,vaccinations.class);
                startActivity(intent);

            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomePage.this,surveillance.class);
                startActivity(intent);

            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomePage.this,conseil.class);
                startActivity(intent);

            }
        });


        // menu code

        Window window = getWindow();
        // Show status bar
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Hide status bar
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);




        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_home :
                       Intent home= new Intent(HomePage.this,HomePage.class);
                       startActivity(home);
                       break;

                    case R.id.menu_medcine :
                        Intent medcine = new Intent(HomePage.this,MedcineCode.class);
                        startActivity(medcine);
                        break;

                    case R.id.menu_vaccination :
                        Intent vaccin= new Intent(HomePage.this,vaccinations.class);
                        startActivity(vaccin);
                        break;
                    case R.id.menu_Surveillance :
                        Intent Surveillance= new Intent(HomePage.this,surveillance.class);
                        startActivity(Surveillance);
                        break;

                    case R.id.menu_Conseils :
                        Intent Conseils= new Intent(HomePage.this,conseil.class);
                        startActivity(Conseils);
                        break;
                    case R.id.menu_AboutUs :
                        Intent AboutUs= new Intent(HomePage.this,about.class);
                        startActivity(AboutUs);
                        break;

                    case R.id.menu_Conatcet :
                        Intent Conatcet= new Intent(HomePage.this,ContanctUsActivity.class);
                        startActivity(Conatcet);
                        break;



                }

                return true;
            }
        });


        //evoaye un sms ou email en cas urgence



        sms = findViewById(R.id.smsBtn);


        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomePage.this,sendemail.class);
                startActivity(intent);

            }
        });


    }
    @SuppressLint("MissingInflatedId")
    private  void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }


}
