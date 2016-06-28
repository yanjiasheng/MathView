package com.mathviews.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 
 * @desc
 * @author yanvictory date 2016-5-24 ÏÂÎç3:11:25
 */
public class QuadraticView extends View {
    private String TAG = QuadraticView.class.getName();
    private int mWidth;
    private int mHeight;
    private Paint mPaint;

    public QuadraticView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        Log.d(TAG, "mWidth:" + mWidth + ",mHeight:" + mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        path.reset();
        for (int p = 0; p < mWidth / 2; p += 1) {
            int x = p;
            double y = Math.pow(x, 2) / 200;
            x = p + mWidth / 2;
            if (p == 0) {
                path.moveTo(x, (float) y);
            } else {
                path.lineTo(x, (float) y);
            }
            Log.d("YJS", "x:" + x);
            Log.d("YJS", "y:" + y);
        }
        for (int p = mWidth / 2; p < mWidth; p += 1) {
            int x = p;
            double y = Math.pow(x - mWidth, 2) / 200;
            x = p - mWidth / 2;
            path.lineTo(x, (float) y);
            Log.d("YJS", "x:" + x);
            Log.d("YJS", "y:" + y);
        }
        // for (int p = 0; p < mWidth; p += 1) {
        // int x = p;
        // int y = ((x-mWidth/2)*(x-mWidth/2))/200 ;
        // if (x == 0) {
        // path.moveTo(x, y);
        // } else {
        // path.lineTo(x, y);
        // }
        // Log.d(TAG, "x:" + x + ",y:" + y);
        // }

        canvas.drawPath(path, mPaint);
    }

}
