package com.mathviews.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/*
 * 
 * @desc y=Asin(mx + n)
 f(x)=Asin（ωx+ψ）
 φ（初相位）：决定波形与X轴位置关系或横向移动距离（左加右减）
 ω：决定周期（最小正周期T=2π/|ω|）
 A：决定峰值（即纵向拉伸压缩的倍数）
 * @author yanvictory
 * date 2016-4-14 下午2:26:52
 */
public class SinView extends View {
    private String TAG = SinView.class.getName();
    private int mA = 70;
    private int mXw = 200;
    private int mCycleCount = 3;
    private int mWidth;
    private int mHeight;
    private Paint mPaint;

    public SinView(Context context, AttributeSet attrs) {
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
        for (float x = 0; x < mWidth; x += 1) {
            float y = mA
                    * (float) Math.sin(x
                            * ((mCycleCount * Math.PI * 2) / mWidth)) + mHeight
                    / 2;
            if (x == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
            Log.d(TAG, "x:" + x + ",y:" + y);
        }
        canvas.drawPath(path, mPaint);
    }

    public void updateParams() {

    }
}
