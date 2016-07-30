package com.ddswez.lpf.myapplication.hack.hack26;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ddswez.lpf.myapplication.R;

public class Hack26Activity extends Activity{


    private TextView mTopHeader; // 悬浮头
    private ListView mListView;
    private int topVisiblePosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack_26);
        mTopHeader = (TextView) findViewById(R.id.header);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mListView.setAdapter(new SectionAdapter(this, Countries.COUNTRIES));
        mListView.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem != topVisiblePosition) {
                    topVisiblePosition = firstVisibleItem;
                    setTopHeader(firstVisibleItem);
                }
            }
        });
        setTopHeader(0);
    }

    public void setTopHeader(int position) {
        mTopHeader.setText(Countries.COUNTRIES[position].substring(0, 1));
    }
}

class SectionAdapter extends ArrayAdapter<String> {

    private Activity activity;
    public SectionAdapter(Activity activity, String[] objects) {
        super(activity, R.layout.activity_hack_26_item, R.id.label, objects);
        this.activity = activity;
        NotificationManager systemService = (NotificationManager)getContext().getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(R.layout.activity_hack_26_item,
                    parent, false);
        }

        TextView header = (TextView) convertView.findViewById(R.id.header);
        String label = getItem(position);
        if (position == 0 || getItem(position - 1).charAt(0) != getItem(position).charAt(0)) {
            header.setVisibility(View.VISIBLE);
            header.setText(label.substring(0, 1));
        } else {
            header.setVisibility(View.GONE);
        }
        return super.getView(position, convertView, parent);
    }
}
