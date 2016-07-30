package com.ddswez.lpf.myapplication.hack.hack7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

public class CancasTestActivity extends AppCompatActivity {

    private DrawView mDrawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        mDrawView = new DrawView(this);
        mDrawView.height = display.getHeight();
        mDrawView.width = display.getWidth();

        setContentView(mDrawView);
    }
}
