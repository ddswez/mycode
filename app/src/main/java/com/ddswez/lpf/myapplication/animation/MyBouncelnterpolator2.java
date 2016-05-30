package com.ddswez.lpf.myapplication.animation;

import android.view.animation.BounceInterpolator;

/**
 * Created by LuPanfeng on 2015/12/18.
 */
public class MyBouncelnterpolator2 extends BounceInterpolator {

    @Override
    public float getInterpolation(float t) {

        if (t < 0.2f) {
            return 2.5f*t + 0.5f;
        } else if (t< 0.8f) {
            return  (4f-5f* t ) /3.0f;
         } else {
//            return ((3f*t-0.82f) * (3f*t-0.82f)-0.25f) *2/1.5f + 0.35f;
            return 2.5f * t -2f;
        }

    }
}
