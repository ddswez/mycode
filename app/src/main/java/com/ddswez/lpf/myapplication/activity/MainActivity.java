package com.ddswez.lpf.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ddswez.lpf.myapplication.R;
import com.ddswez.lpf.myapplication.dashSpinner.DashSpinnerActivity;
import com.ddswez.lpf.myapplication.piechar.PieCharActivity;
import com.ddswez.lpf.myapplication.piechar.PieCharActivity2;
import com.ddswez.lpf.myapplication.swipeListView.BtnAndImgOnClick;

import org.feezu.liuli.timeselector.TimeSelector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected final String Tag = "MainActivity";
    private Button listViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        listViewBtn = (Button)findViewById(R.id.btn_listView);
        listViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BtnAndImgOnClick.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_view).setOnClickListener(this);
        findViewById(R.id.btn_Interpolator).setOnClickListener(this);
        findViewById(R.id.btn_time_view).setOnClickListener(this);
        findViewById(R.id.btn_dash_spinner).setOnClickListener(this);
        findViewById(R.id.btn_pie_char).setOnClickListener(this);
        findViewById(R.id.btn_pie_char2).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view :
                startActivity(new Intent(MainActivity.this, MyViewActivity.class));
                break;
            case R.id.btn_Interpolator :
                startActivity(new Intent(MainActivity.this, InterpolatorActivity.class));
                break;
            case R.id.btn_time_view :
                showTimeView();
                break;
            case R.id.btn_dash_spinner :
                startActivity(new Intent(MainActivity.this, DashSpinnerActivity.class));
                break;
            case R.id.btn_pie_char :
                startActivity(new Intent(MainActivity.this, PieCharActivity.class));
                break;
            case R.id.btn_pie_char2 :
                startActivity(new Intent(MainActivity.this, PieCharActivity2.class));
                break;
        }
    }

    private void showTimeView() {
        TimeSelector timeSelector = new TimeSelector(this, new TimeSelector.ResultHandler() {
            @Override
            public void handle(String time) {
                Toast.makeText(getApplicationContext(), time, Toast.LENGTH_LONG).show();
            }
        }, "1900-01-01 00:00", "2015-12-1 15:20");
        timeSelector.show();
//        timeSelector.setMode(TimeSelector.MODE.YMD);//只显示 年月日
    }
}
