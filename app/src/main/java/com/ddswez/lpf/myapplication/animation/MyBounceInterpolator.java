package com.ddswez.lpf.myapplication.animation;

import android.util.Log;
import android.view.animation.BounceInterpolator;

/**
 * Created by LuPanfeng on 2015/12/18.
 */
public class MyBounceInterpolator extends BounceInterpolator {

    @Override
    public float getInterpolation(float t) {
        t *= 1.1226f;
//        if (t < 0.3535f) {
//            Log.v("lpf++++++  ", "t === " + t + "  bounce(t) == " + bounce(t));
//            return bounce(t);
//        }
//        else if (t < 0.7408f) {
//            Log.v("lpf++++++  ", "t === " + t + "  bounce(t) == " + (bounce(t - 0.54719f) + 0.7f));
//            return bounce(t - 0.54719f) + 0.7f;
//        }
//        else if (t < 0.9644f) {
//            Log.v("lpf++++++  ", "t === " + t + "  bounce(t) == " + (bounce(t - 0.8526f) + 0.9f));
//            return bounce(t - 0.8526f) + 0.9f;
//        }
//        else {
//            Log.v("lpf++++++  ", "t === " + t + "  bounce(t) == " + (bounce(t - 1.0435f) + 0.95f));
//            return bounce(t - 1.0435f) + 0.95f;
//        }
//        else return 0f;   t === 0.8666472


        if (t < 0.3535f) {
            Log.v("lpf++++++  ", "t === " + t + "  bounce(t) == " + bounce(t));
            return bounce(t);
        }
        else if (t < 0.7408f) {
            Log.v("lpf++++++  ", "t === " + t + "  bounce(t) == " + bounce(t - 0.54719f) + 0.7f);
            return bounce(t - 0.54719f) + 0.7f;
        }

        else {
            float f = 1 - bounce(t - 0.7408f);
            return  f < 0 ? 0 : f;
        }
    }

    private static float bounce(float t) {
        return t * t * 8.0f;
    }

}
