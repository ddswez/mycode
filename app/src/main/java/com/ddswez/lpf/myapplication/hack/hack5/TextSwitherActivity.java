package com.ddswez.lpf.myapplication.hack.hack5;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

import com.ddswez.lpf.myapplication.R;

/**
 * 文字淡入淡出效果
 * 打造搞质量Android应用 Hack 5
 * @author lupanfeng
 * @date 2016/6/4
 */
public class TextSwitherActivity extends Activity {


    private TextSwitcher mTextSwitcher;
    private int i = 10;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_swither);
        init();
    }

    private void init() {
        // 自带淡入淡出效果
//        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
//        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        Animation in = AnimationUtils.loadAnimation(this, R.anim.textswitcher_in);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.textswitcher_out);


        mTextSwitcher = (TextSwitcher) findViewById(R.id.txt_switcher);
        mTextSwitcher.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(TextSwitherActivity.this);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(40);
                tv.setText("退出");
                return tv;
            }
        });

        mTextSwitcher.setInAnimation(in);
        mTextSwitcher.setOutAnimation(out);

        findViewById(R.id.button_begin).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextSwitcher.setText("进入");
            }
        });

        findViewById(R.id.button_recover).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextSwitcher.setText("退出");
            }
        });

        findViewById(R.id.button_timer).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.post(r);
            }
        });
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            if (i == -1) return;
            mTextSwitcher.setText("" + i);
            i--;
            mHandler.postDelayed(r, 1000);
        }
    };
}
