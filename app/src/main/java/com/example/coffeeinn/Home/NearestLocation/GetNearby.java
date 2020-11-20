/*package com.example.coffeeinn.Home.NearestLocation;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class GetNearby extends AsyncTask<Object, String, String> {
    String googlePlaceData;
    GoogleMap googleMap;
    String url;

    @Override
    protected String doInBackground(Object... objects) {
        googleMap (GoogleMap) objects[0];
        url = (String) objects[1];

        DownloadUrl downloadUrl = new DownloadUrl();
        try {
            googlePlaceData = downloadUrl.readUrl(url);
        }
        catch (IOException){
            e.printStackTrace();
        }

        return  googlePlaceData;
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject parentObject = new JSONObject(a);
            JSONArray resultArray = parentObject.getJSONArray("results");

            for (int i =0; i<resultArray.length(); i++){
                JSONObject jsonObject =resultArray.getJSONObject(i);
                JSONObject locationobj = jsonObject.getJSONObject("geometry").getJSONObject("location");

            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }
}
*/