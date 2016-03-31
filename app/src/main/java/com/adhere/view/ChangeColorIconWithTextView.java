package com.adhere.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.adhere.loadview.R;

/**
 * Author by gaojun on 16/2/28.
 * description：
 * 自定义Tap切换View
 */


public class ChangeColorIconWithTextView extends View {

    /**
     * 按下时的颜色
     */
    private int mColorDown ;

    /**
     * 未按下的颜色
     */
    private int mColorNormal;

    private boolean mDown = false;
    /**
     * 图标
     */
    private Bitmap mIconBitmap;

    /**
     * 按下的图标
     */
    private Bitmap mIconBitmapDown;
    /**
     * 限制绘制icon的范围
     */
    private Rect mIconRect;
    /**
     * icon底部文本
     */
    private String mText = "首页";
    private int mTextSize = (int) TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics());
    private Paint mTextPaint;
    private Rect mTextBound = new Rect();

    public ChangeColorIconWithTextView(Context context) {
        super(context);
    }

    /**
     * 初始化自定义属性值
     *
     * @param context
     * @param attrs
     */
    public ChangeColorIconWithTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 获取设置的图标
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ChangeColorIconView);

        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.ChangeColorIconView_icon_normal:
                    BitmapDrawable drawable = (BitmapDrawable) a.getDrawable(attr);
                    mIconBitmap = drawable.getBitmap();
                    break;


                case R.styleable.ChangeColorIconView_icon_down:
                    BitmapDrawable drawable_down = (BitmapDrawable) a.getDrawable(attr);
                    mIconBitmapDown = drawable_down.getBitmap();
                    break;

                case R.styleable.ChangeColorIconView_color_down:
                    mColorDown = a.getColor(attr, 0xFF45C01A);
                    break;
                case R.styleable.ChangeColorIconView_color_normal:
                    mColorNormal=a.getColor(attr,0xff919191);
                    break;
                case R.styleable.ChangeColorIconView_text:
                    mText = a.getString(attr);
                    break;
                case R.styleable.ChangeColorIconView_text_size:
                    mTextSize = (int) a.getDimension(attr, TypedValue
                            .applyDimension(TypedValue.COMPLEX_UNIT_SP, 10,
                                    getResources().getDisplayMetrics()));
                    break;

            }
        }

        a.recycle();
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(mTextSize);
//        mTextPaint.setFakeBoldText(true);
        // 得到text绘制范围
        mTextPaint.getTextBounds(mText, 0, mText.length(), mTextBound);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 得到绘制icon的宽
        int bitmapWidth = Math.min(getMeasuredWidth() - getPaddingLeft()
                - getPaddingRight(), getMeasuredHeight() - getPaddingTop()
                - getPaddingBottom() - mTextBound.height());

        int left = getMeasuredWidth() / 2 - bitmapWidth / 2;
        int top = (getMeasuredHeight() - mTextBound.height()) / 2 - bitmapWidth
                / 2;
        // 设置icon的绘制范围（left,top,right,bottom）
        mIconRect = new Rect(left, top, left + bitmapWidth, top + bitmapWidth);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (mDown) {
            canvas.drawBitmap(mIconBitmapDown, null, mIconRect, null);
            drawTargetText(canvas);
        } else {
            canvas.drawBitmap(mIconBitmap, null, mIconRect, null);
            drawSourceText(canvas);
        }

    }


    //设置未按下的颜色
    private void drawSourceText(Canvas canvas) {
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setColor(mColorNormal);
        canvas.drawText(mText, mIconRect.left + mIconRect.width() / 2
                        - mTextBound.width() / 2,
                mIconRect.bottom + mTextBound.height()/2, mTextPaint);
    }

    private void drawTargetText(Canvas canvas) {
        mTextPaint.setColor(mColorDown);
        canvas.drawText(mText, mIconRect.left + mIconRect.width() / 2
                        - mTextBound.width() / 2,
                mIconRect.bottom + mTextBound.height()/2, mTextPaint);

    }


    public void setIconDown(boolean down) {
        mDown = down;
        invalidateView();
    }

    private void invalidateView() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }


}

