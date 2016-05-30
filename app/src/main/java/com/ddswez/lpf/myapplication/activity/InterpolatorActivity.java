package com.ddswez.lpf.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.ddswez.lpf.myapplication.R;
import com.ddswez.lpf.myapplication.animation.MyBounceInterpolator;

public class InterpolatorActivity extends AppCompatActivity {
    private TextView tv;
    private Button btnRun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        tv = (TextView) findViewById(R.id.tv);

        btnRun = (Button) findViewById(R.id.btn_run);
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnimation();
            }
        });
//        initAnimation();
    }

    private void initAnimation() {

        ScaleAnimation animation = new ScaleAnimation(0.8f,1.4f,0.8f,1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        tv.setAnimation(animation);
        animation.setDuration(5000);
//        animation.setInterpolator(new AccelerateDecelerateInterpolator());
//        animation.setInterpolator(new BounceInterpolator());
        animation.setInterpolator(new MyBounceInterpolator());

//        animation.setInterpolator(new MyBouncelnterpolator2());
//        DecelerateInterpolator
//        animation.setInterpolator(new DecelerateInterpolator());
          tv.startAnimation(animation);
    }


}
