package com.example.coffeeinn.Initialization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.coffeeinn.About.AboutFragment;
import com.example.coffeeinn.Home.HomeFragment;
import com.example.coffeeinn.Partnership.PartnerFragment;
import com.example.coffeeinn.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_bar);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.setSelectedItemId(R.id.homeFragment);

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;
                    switch (item.getItemId())
                    {
                        case R.id.partnerFragment:
                            selectedFragment = new PartnerFragment();
                            break;
                        case R.id.homeFragment:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.aboutFragment:
                            selectedFragment = new AboutFragment();
                            break;
                    }

                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.fadein, R.anim.fadeout)
                                .replace(R.id.fragment_container, selectedFragment, "my_fragment").commit();
                    return true;
                }
            };

}