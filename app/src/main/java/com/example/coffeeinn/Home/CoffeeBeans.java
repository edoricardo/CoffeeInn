package com.example.coffeeinn.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.coffeeinn.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoffeeBeans#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoffeeBeans extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CoffeeBeans() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoffeeBeans.
     */
    // TODO: Rename and change types and number of parameters
    public static CoffeeBeans newInstance(String param1, String param2) {
        CoffeeBeans fragment = new CoffeeBeans();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coffee_beans, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_arabica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.animate_card_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_left_exit);
                Fragment selected = new CoffeeBeans_Arabica();
                fragmentTransaction.replace(R.id.fragment_container, selected);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        view.findViewById(R.id.button_robusta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.animate_card_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_left_exit);
                Fragment selected = new CoffeeBeans_Robusta();
                fragmentTransaction.replace(R.id.fragment_container, selected);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

    }
}