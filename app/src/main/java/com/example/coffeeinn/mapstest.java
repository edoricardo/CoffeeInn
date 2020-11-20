package com.example.coffeeinn;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.coffeeinn.Home.CoffeeBeans.CoffeeBeans_Arabica;
import com.example.coffeeinn.Home.CoffeeBeans.CoffeeBeans_Robusta;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mapstest#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mapstest extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //for webview
    public WebView mWebView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mapstest() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mapstest.
     */
    // TODO: Rename and change types and number of parameters
    public static mapstest newInstance(String param1, String param2) {
        mapstest fragment = new mapstest();
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


      //  getmWebView();
        //for web view in fragment
        View v=inflater.inflate(R.layout.fragment_mapstest, container, false);
        mWebView = (WebView) v.findViewById(R.id.webviewMaps);
        //map link webview
        mWebView.loadUrl("https://www.google.com/maps/search/coffee+shop+terdekat");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());


        return v;


        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_mapstest, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.nearestloc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.animate_card_enter, R.anim.fadeout, R.anim.fadein, R.anim.animate_slide_left_exit);
                //new java class name
                Fragment selected = new mapstest();
                fragmentTransaction.replace(R.id.fragment_container, selected);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }
}