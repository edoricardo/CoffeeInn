package com.example.coffeeinn.Initialization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.coffeeinn.MainActivity;

public class check_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        SharedPreferences settings=getSharedPreferences("prefs",0);
        boolean firstRun = settings.getBoolean("firstRun",false);
        if(!firstRun)//if running for first time
        //Splash will load for first time
        {
            SharedPreferences.Editor editor=settings.edit();
            editor.putBoolean("firstRun",true);
            editor.apply();
            Intent i=new Intent(check_splash.this, Splash.class);
            startActivity(i);
            finish();
        }

        else
        {

            Intent a = new Intent(check_splash.this, MainActivity.class);
            startActivity(a);
            finish();
        }
    }

}