package com.example.ina97.myapplication;

import android.net.sip.SipSession;
import android.util.Base64;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.ErrorListener;

public class TokenRequest extends JsonObjectRequest{
    TokenRequest(int method, String url, JSONObject jsonObject, Response.Listener<JSONObject> listener,
                 Response.ErrorListener errorListener) {
        super(method, url, jsonObject, listener, errorListener);
    }

    public Map<String, String> getHeaders() throws AuthFailureError{
        Map<String, String> headers= new HashMap<String, String>();

        String credentials= "name:password";
        String auth = "Basic"
                + Base64.encodeToString(credentials.getBytes(),Base64.NO_WRAP);

        headers.put("Content-type", "application/json");
        headers.put("Authorization", auth);
        return headers;

    }
}
