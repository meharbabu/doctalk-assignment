package com.csg.app.network;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.csg.app.adapters.ItemsAdapter;
import com.csg.app.models.Items;
import com.csg.app.models.Mediator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

public class NetworkUtils {

    public static void connectServerAndGetData(String searchName) {
        try {
            String SERVER_URL = "https://api.github.com/search/users?q="+searchName+"&followers:>100&order=asc";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, SERVER_URL, new JSONObject(),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                // Gson to convert json data to models
                                GsonBuilder gsonBuilder = new GsonBuilder();
                                Gson gson = gsonBuilder.create();
                                final Items items = gson.fromJson(response.toString(), Items.class);
                                ItemsAdapter itemsAdapter = new ItemsAdapter(items.getItemsList());
                                if(Mediator.getInstance().getMainActivityContext() != null) {
                                    // Setting adapter to recycler view to display venues
                                    Mediator.getInstance().getMainActivityContext().recyclerView.setAdapter(itemsAdapter);
                                    Mediator.getInstance().getMainActivityContext().recyclerView.setLayoutManager(new LinearLayoutManager(Mediator.getInstance().getMainActivityContext()));
                                    // Hiding progressbar after loading
                                    Mediator.getInstance().getMainActivityContext().progressBar.setVisibility(View.GONE);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Mediator.getInstance().getMainActivityContext(),"Can't connect to server",Toast.LENGTH_LONG).show();
                    Mediator.getInstance().getMainActivityContext().progressBar.setVisibility(View.GONE);
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(Mediator.getInstance().getMainActivityContext());
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
