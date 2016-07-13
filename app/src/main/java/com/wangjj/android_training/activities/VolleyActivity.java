package com.wangjj.android_training.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wangjj.android_training.R;

/**
 * Created by wangjj on 2016/7/5.
 */
public class VolleyActivity extends AppCompatActivity {
    private final String TAG = "VolleyActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        RequestQueue mQuene = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest("https://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.getMessage(), error);
            }
        });
        mQuene.add(stringRequest);
    }
}
