package com.example.coffeeinn.Home.PopularCoffee;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coffeeinn.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PopularCoffee#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PopularCoffee extends Fragment implements AdapterView.OnItemClickListener {

    Typeface popFont;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PopularCoffee() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PopularCoffee newInstance(String param1, String param2) {
        PopularCoffee fragment = new PopularCoffee();
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
        popFont = Typeface.createFromAsset(getContext().getAssets(),"fonts/panton_black_caps.otf");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pcoffee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] pop = {"Cold Brew", "Espresso", "Ground Coffee","Espresso Americano", "Double Expresso", "Capuccino", "Caffe Latte", "Caffe Mocha", "Flat White", "Long Black"};
        ListView listView = (ListView) getView().findViewById(R.id.listpop);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, pop) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
            {
                TextView item = (TextView) super.getView(position, convertView, parent);

                item.setTypeface(popFont);

                item.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);

                return  item;
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Fragment selected = null;

        switch (i)
        {
            case 0:
                selected = new PopularCoffee_ColdBrew();
                break;
            case 1:
                selected = new PopularCoffee_Espresso();
                break;
            case 2:
                selected = new PopularCoffee_GroundCoffee();
                break;
        }

        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.animate_card_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_left_exit);
        fragmentTransaction.replace(R.id.fragment_container, selected);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}