package com.ddswez.lpf.myapplication.swipeListView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ddswez.lpf.myapplication.R;

public class BtnAndImgOnClick extends Activity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_and_img_on_click);

        ListView mList = (ListView) findViewById(R.id.lv);
        mList.setAdapter(new MyAdapter(BtnAndImgOnClick.this));


    }

}
