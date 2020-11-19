package com.example.coffeeinn.Initialization;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.coffeeinn.MainActivity;
import com.example.coffeeinn.R;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;


public class ImageCarousel extends AppCompatActivity {

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3, R.drawable.slide_4};


            String prevStarted = "prevStarted";
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
        } else {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_carousel);

        final ArrayList<View> viewsToFadeIn = new ArrayList<View>();

        viewsToFadeIn.add(findViewById(R.id.button_start));

        for (View v : viewsToFadeIn)
        {
            v.setAlpha(0); // make invisible to start
        }


        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);


        carouselView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3)
                {
                    for (View v : viewsToFadeIn)
                    {
                        v.animate().alpha(1.0f).setDuration(250).start();
                    }
                }

                else if (position != 3)
                {
                    for (View v : viewsToFadeIn)
                    {
                        v.animate().alpha(0.0f).setDuration(250).start();
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.get().load(sampleImages[position]).fit().centerCrop().into(imageView);
        }
    };

    public void Test(View view) {
        Intent intent = new Intent(ImageCarousel.this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateSplit(ImageCarousel.this);
        finish();
    }
}