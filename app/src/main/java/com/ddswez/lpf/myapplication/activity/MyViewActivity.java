package com.ddswez.lpf.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.ddswez.lpf.myapplication.R;
import com.ddswez.lpf.myapplication.view.RoundProgressView;

public class MyViewActivity extends AppCompatActivity {

    private RoundProgressView mRoundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        init();
    }

    private void init() {
        Switch sw = (Switch) findViewById(R.id.switch_kaiguan);
        mRoundView = (RoundProgressView)findViewById(R.id.rpb_view);
        sw.setChecked(true);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MyViewActivity.this, "开关打开了", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MyViewActivity.this, "开关关闭了", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mRoundView.setCricleColor(getResources().getColor(R.color.txt_gray_dark));
        mRoundView.setCricleProgressColor(getResources().getColor(R.color.orange));
        mRoundView.setProgress(30);
        mRoundView.setRoundWidth(15);
        mRoundView.setTextSize(50);
        mRoundView.setText("进行中");
        mRoundView.setTextColor(getResources().getColor(R.color.orange));

    }


}
