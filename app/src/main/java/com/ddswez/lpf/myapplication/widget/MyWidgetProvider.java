package com.ddswez.lpf.myapplication.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by LuPanfeng on 2016/3/13.
 */
public class MyWidgetProvider extends AppWidgetProvider {
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        System.out.println("onReceive");
    }

    /**
     * 当第一个widget被创建时,调用此方法
     */
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        System.out.println("onEnabled");
        // 开启定时更新的服务
        context.startService(new Intent(context, UpdateWidgetService.class));
    }

    /**
     * 当新增widget时, 自动更新时也会调用 android:updatePeriodMillis="1800000"
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        System.out.println("onUpdate");
        // 开启定时更新的服务
        context.startService(new Intent(context, UpdateWidgetService.class));
    }

    /**
     * widget被删除时调用
     */
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        System.out.println("onDeleted");
    }

    /**
     * 最后一个widget被移除时调用
     */
    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        System.out.println("onDisabled");
        // 停止定时更新的服务
        context.stopService(new Intent(context, UpdateWidgetService.class));
    }

    /**
     * 宽高发生变化后调用
     */
    @Override
    public void onAppWidgetOptionsChanged(Context context,
                                          AppWidgetManager appWidgetManager, int appWidgetId,
                                          Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId,
                newOptions);
        System.out.println("onAppWidgetOptionsChanged");
    }
}
