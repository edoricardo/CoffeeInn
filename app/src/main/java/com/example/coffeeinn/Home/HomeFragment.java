package com.example.coffeeinn.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;

import com.example.coffeeinn.R;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment #newInstance} factory method to
 * create an instance of this fragment.

 */
public class HomeFragment extends Fragment {
    private ViewFlipper v_flipper;

    //public HomeFragment(){

    // }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        int images[] = {R.drawable.coffee_statistic, R.drawable.coffee_statistic01,
                R.drawable.coffee_statistic02, R.drawable.coffee_statistic03};

        v_flipper = rootView.findViewById(R.id.homeFragment);

        for (int image: images){
            flipperImages(image);
        }

        return rootView;

    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getActivity());


        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        v_flipper.setOutAnimation(getActivity(), android.R.anim.fade_out);
        v_flipper.setInAnimation(getActivity(), android.R.anim.fade_in);

    }
}