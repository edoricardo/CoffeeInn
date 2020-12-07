package com.example.coffeeinn.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeeinn.Home.BrewingMethods.BrewingMethods;
import com.example.coffeeinn.Home.CoffeeBeans.CoffeeBeans;
import com.example.coffeeinn.Home.IndonesianCoffee.IndonesianCoffee;
import com.example.coffeeinn.Home.PopularCoffee.PopularCoffee;
import com.example.coffeeinn.MapsFragment;
import com.example.coffeeinn.R;
import com.example.coffeeinn.Home.Videos.Videos;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {  // it should use OnViewCreated Method
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_coffeebeans).setOnClickListener(new View.OnClickListener() { // In the R.id, use the id of your button
            @Override
            public void onClick(View view) { // Use the R.id. of your button/ImageView/ImageButton you want to press
                FragmentManager fragmentManager = getFragmentManager();
                assert fragmentManager != null;
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.animate_card_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_left_exit);
                Fragment selected = new CoffeeBeans();  // Use the java class you want to go to (this is the destination fragment)
                fragmentTransaction.replace(R.id.fragment_container, selected);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        view.findViewById(R.id.button_videos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.animate_card_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_left_exit);
                Fragment selected = new Videos();
                fragmentTransaction.replace(R.id.fragment_container, selected);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        view.findViewById(R.id.button_popularcoffee).setOnClickListener(new View.OnClickListener() { // In the R.id, use the id of your button
            @Override
            public void onClick(View view) { // Use the R.id. of your button/ImageView/ImageButton you want to press
                FragmentManager fragmentManager = getFragmentManager();
                assert fragmentManager != null;
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.animate_slide_up_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_down_exit);
                Fragment selected = new PopularCoffee();  // Use the java class you want to go to (this is the destination fragment)
                fragmentTransaction.replace(R.id.fragment_container, selected);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        view.findViewById(R.id.button_brewingmethods).setOnClickListener(new View.OnClickListener() { // In the R.id, use the id of your button
            @Override
            public void onClick(View view) { // Use the R.id. of your button/ImageView/ImageButton you want to press
                FragmentManager fragmentManager = getFragmentManager();
                assert fragmentManager != null;
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.animate_slide_up_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_down_exit);
                Fragment selected = new BrewingMethods();  // Use the java class you want to go to (this is the destination fragment)
                fragmentTransaction.replace(R.id.fragment_container, selected);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        view.findViewById(R.id.button_indocoffee).setOnClickListener(new View.OnClickListener() { // In the R.id, use the id of your button
            @Override
            public void onClick(View view) { // Use the R.id. of your button/ImageView/ImageButton you want to press
                FragmentManager fragmentManager = getFragmentManager();
                assert fragmentManager != null;
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.animate_slide_up_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_down_exit);
                Fragment selected = new IndonesianCoffee();  // Use the java class you want to go to (this is the destination fragment)
                fragmentTransaction.replace(R.id.fragment_container, selected);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

/*        view.findViewById(R.id.button_location).setOnClickListener(new View.OnClickListener() { // In the R.id, use the id of your button
            @Override
            public void onClick(View view) { // Use the R.id. of your button/ImageView/ImageButton you want to press
                FragmentManager fragmentManager = getFragmentManager();
                assert fragmentManager != null;
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.animate_slide_up_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_down_exit);
                Fragment selected = new MapsFragment();  // Use the java class you want to go to (this is the destination fragment)
                fragmentTransaction.replace(R.id.fragment_container, selected);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });*/

    }
}

