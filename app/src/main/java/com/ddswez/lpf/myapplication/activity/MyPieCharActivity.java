package com.ddswez.lpf.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ddswez.lpf.myapplication.R;
import com.ddswez.lpf.myapplication.view.MyPieCharView;

import java.util.ArrayList;

public class MyPieCharActivity extends AppCompatActivity {

    private MyPieCharView mCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pie_char);
        init();
    }

    private void init() {
        mCircleView = (MyPieCharView)findViewById(R.id.circle_view);

//        mCircleView.setCricleColor(getResources().getColor(R.color.tab_bar_color));
//        mCircleView.setCricleProgressColor(getResources().getColor(R.color.orange));
//        mCircleView.setProgress(30);

        ArrayList<Float> pges = new ArrayList<>();
        pges.add(25f);
        pges.add(25f);
        pges.add(25f);
        pges.add(25f);

        mCircleView.setProgress(pges);

        // 图形宽度
        mCircleView.setRoundWidth(150);

//        // 圆环中间的文字
//        mCircleView.setText("哈哈");
//        mCircleView.setTextSize(50);
//        mCircleView.setTextColor(getResources().getColor(R.color.orange));
    }


}
