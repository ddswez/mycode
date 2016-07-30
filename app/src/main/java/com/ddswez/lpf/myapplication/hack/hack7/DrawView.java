package com.ddswez.lpf.myapplication.hack.hack7;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * 方块挑动
 *
 */
public class DrawView extends View {
    private Rectangle mRectangle;
    public int width;
    public int height;

    public DrawView(Context context) {
        super(context);

        mRectangle = new Rectangle(context, this);
        mRectangle.setARGB(255, 255, 0, 0);
        mRectangle.setSpeedX(3);
        mRectangle.setSpeedY(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        /**
         * 绘制-->坐标变换-->刷新从绘
         */
        mRectangle.move();
        mRectangle.onDraw(canvas);

        invalidate();
    }

}