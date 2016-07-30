package com.ddswez.lpf.myapplication.hack.hack11;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ddswez.lpf.myapplication.R;

import java.util.Date;

/**
 * LED显示效果
 *
 * @author lupanfeng
 * @date 2016/6/13 15:12
 */
public class Hack11LEDActivity extends AppCompatActivity {

    private static final String DATE_FORMAT = "%02d:%02d:%02d";
    private static final int REFRESH_DELAY = 500;

    private final Handler mHandler = new Handler();
    private final Runnable mTimeRefresher = new Runnable() {
        @Override
        public void run() {
            final Date d = new Date();
            mTextView.setText(String.format(DATE_FORMAT, d.getHours(),
                    d.getMinutes(), d.getSeconds()));
            mHandler.postDelayed(this, REFRESH_DELAY);
        }
    };

    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack11_led);

        mTextView = (TextView) findViewById(R.id.main_clock_time);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.post(mTimeRefresher);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mTimeRefresher);
    }

}
