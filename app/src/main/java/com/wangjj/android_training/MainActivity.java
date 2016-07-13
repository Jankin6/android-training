package com.wangjj.android_training;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.wangjj.android_training.activities.DaggerActivity;
import com.wangjj.android_training.activities.VolleyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_mvp)
    Button mBtnMvp;
    @BindView(R.id.btn_gesture_detector)
    Button mBtnGestureDetector;
    @BindView(R.id.btn_dagger)
    Button mBtnDagger;
    @BindView(R.id.btn_volley)
    Button mBtnVolley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_dagger)
    void onBtnDaggerClick() {
        startActivity(new Intent(this, DaggerActivity.class));
    }

    @OnClick(R.id.btn_volley)
    void onBtnVolleyClick(){
        startActivity(new Intent(this, VolleyActivity.class));
    }
}
