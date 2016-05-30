package com.ddswez.lpf.myapplication.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.RemoteViews;

import com.ddswez.lpf.myapplication.R;
import com.ddswez.lpf.myapplication.activity.MainActivity;

import java.util.Timer;
import java.util.TimerTask;


/**
 * 定时更新widget的服务
 * 
 * @author Kevin
 * 
 */
public class UpdateWidgetService extends Service {

	private InnerScreenReceiver mReceiver;

	private Timer mTimer;
	private AppWidgetManager mAWM;
	int i = 0;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		startTimer();

		// 注册屏幕关闭/开启的广播
		mReceiver = new InnerScreenReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		filter.addAction(Intent.ACTION_SCREEN_ON);
		registerReceiver(mReceiver, filter);

	}

	private void startTimer() {
		mTimer = new Timer();

		mTimer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				System.out.println("更新widget啦!!!");
				updateWidget();
			}
		}, 0, 5000);
	}

	/**
	 * 更新widget
	 */
	protected void updateWidget() {
		mAWM = AppWidgetManager.getInstance(this);// widget管理器
		// 初始化widget组件
		ComponentName provider = new ComponentName(this, MyWidgetProvider.class);
		System.out.println("i=====" + i);
		// 初始化远程的view对象
		RemoteViews views = new RemoteViews(getPackageName(),
				R.layout.example_appwidget);
		views.setTextViewText(
				R.id.tv_text, "hahah" + i);
		views.setTextViewText(
				R.id.btn_button,
				"heheh" + i);
		if (i % 2 == 0) {
			views.setTextViewText(R.id.btn_button2, "测试消失" + i);
		} else {
			views.setTextViewText(R.id.btn_button2, "");
		}

		i = i + 1;
		// 要跳转页面的intent
		Intent intent = new Intent(this, MainActivity.class);
		// 延时的intent, 等待中的intent
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				intent, PendingIntent.FLAG_UPDATE_CURRENT);
		// 设置点击后的事件
		views.setOnClickPendingIntent(R.id.ll_root, pendingIntent);

		mAWM.updateAppWidget(provider, views);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		mTimer.cancel();
		mTimer = null;

		unregisterReceiver(mReceiver);
		mReceiver = null;
	}

	class InnerScreenReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
				System.out.println("屏幕关闭");
				if (mTimer != null) {
					mTimer.cancel();
				}
			} else {
				System.out.println("屏幕开启");
				startTimer();
			}
		}

	}

}
