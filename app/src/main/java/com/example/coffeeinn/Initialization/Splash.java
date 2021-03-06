package com.example.coffeeinn.Initialization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.coffeeinn.R;

public class Splash extends AppCompatActivity {

    private int loading_time = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home=new Intent(Splash.this, ImageCarousel.class);
                startActivity(home);
                Animatoo.animateSlideUp(Splash.this);
                finish();
            }
        },loading_time);
    }
}