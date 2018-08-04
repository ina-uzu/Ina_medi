package com.example.ina97.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class MainActivity extends Activity {

    Button bt_login;
    EditText p_name, p_num;
    String name;
    Integer number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt_login = findViewById(R.id.bt_login);
        p_name = findViewById(R.id.p_name);
        p_num= findViewById(R.id.p_num);

        //Login info
        name= p_name.getText().toString();
        number=parseInt(p_num.getText().toString());

/*
        final RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://54.202.222.14/accounts/login";

        final JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST,url, new JSONObject(), networkSuccessListener(), networkErrorListener()){
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();

                String credentials = name+":"+number;
                String auth = "Basic"
                        + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);

                return headers;
            }
        };
        */

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("Name", name);
                intent.putExtra("Number", number);

                //요청
                //queue.add(objectRequest);
                startActivity(intent);
            }
        });
    }

    private Response.Listener<JSONObject> networkSuccessListener(){
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String valStr=null;
                String keyStr=null;

                Iterator <String> key = response.keys();
                try{
                    keyStr = key.next();
                    valStr = response.getString(keyStr);
                }
                catch (JSONException e){
                    e.printStackTrace();
                }

            }
        };
    }

    private Response.ErrorListener networkErrorListener(){
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
    }
}


