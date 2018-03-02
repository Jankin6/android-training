package com.wangjj.android_training.activities.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wangjj.android_training.R;
import com.wangjj.android_training.annotation.ContentView;
import com.wangjj.android_training.annotation.InjectView;
import com.wangjj.android_training.annotation.ViewInjectUtil;



@ContentView(R.layout.activity_annotation)
public class TestAnnotationActivity extends AppCompatActivity {
    @InjectView(R.id.tv)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjectUtil.inject(this);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

}
