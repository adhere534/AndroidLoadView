package com.adhere.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Author:gaojun
 * time:2016/2/28
 */
public class ZoomImageView extends ImageView {
    public ZoomImageView(Context context) {
        super(context);
    }

    public ZoomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZoomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @SuppressLint("ClickableViewAccessibility") @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setAlpha(0.3f);
                break;
            case MotionEvent.ACTION_UP:
                setAlpha(1.0f);
                break;
            case MotionEvent.ACTION_CANCEL:
                setAlpha(1.0f);
                break;

            default:
                break;
        }

        return super.onTouchEvent(event);
    }

}
