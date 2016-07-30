package com.ddswez.lpf.myapplication.hack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.ddswez.lpf.myapplication.R;
import com.ddswez.lpf.myapplication.hack.hack11.Hack11LEDActivity;
import com.ddswez.lpf.myapplication.hack.hack26.Hack26Activity;
import com.ddswez.lpf.myapplication.hack.hack5.TextSwitherActivity;
import com.ddswez.lpf.myapplication.hack.hack7.CancasTestActivity;

public class HackActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack);
        findViewById(R.id.txt_switcher).setOnClickListener(this);
        findViewById(R.id.cancas).setOnClickListener(this);
        findViewById(R.id.led).setOnClickListener(this);
        findViewById(R.id.list_view_top_header).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_switcher:
                startActivity(new Intent(HackActivity.this, TextSwitherActivity.class));
                break;
            case R.id.cancas:
                startActivity(new Intent(HackActivity.this, CancasTestActivity.class));
                break;
            case R.id.led:
                startActivity(new Intent(HackActivity.this, Hack11LEDActivity.class));
                break;
            case R.id.list_view_top_header:
                startActivity(new Intent(HackActivity.this, Hack26Activity.class));
                break;
        }
    }
}
