package com.example.jsondata2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        final TextView textView = findViewById(R.id.textview);

        final String url ="https://www.reddit.com/";
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        //String text = url.body().string();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final JsonObjectRequest objectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                              // Log.d("rest Respnse",response.toString());

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("rest Respnse",error.toString());


                            }
                        }

                );
                requestQueue.add(objectRequest);


            }
        });


    }
}
