package com.example.coffeeinn.Home.IndonesianCoffee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeeinn.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IndonesianCoffee_KopiLiberikaRangsangMerantiRiau#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndonesianCoffee_KopiLiberikaRangsangMerantiRiau extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IndonesianCoffee_KopiLiberikaRangsangMerantiRiau() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndonesianCoffee_KopiLiberikaRangsangMerantiRiau.
     */
    // TODO: Rename and change types and number of parameters
    public static IndonesianCoffee_KopiLiberikaRangsangMerantiRiau newInstance(String param1, String param2) {
        IndonesianCoffee_KopiLiberikaRangsangMerantiRiau fragment = new IndonesianCoffee_KopiLiberikaRangsangMerantiRiau();
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
        return inflater.inflate(R.layout.fragment_indocoffee_kopiliberikarangsangmerantiriau, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {  // it should use OnViewCreated Method
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.back_icon).setOnClickListener(new View.OnClickListener() { // In the R.id, use the id of your button
            @Override
            public void onClick(View view) { // Use the R.id. of your button/ImageView/ImageButton you want to press
                getFragmentManager().popBackStackImmediate();

            }
        });
    }
}