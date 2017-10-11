package xiaoheihei.example.com.beisaierquxiantest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by xhh on 2017/10/11.
 */

public class MyView extends View {
    private int mItemWaveLen = 400;
    private int dx ;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(5);
        Path path = new Path();
        path.reset();





        int originY = 300;
        int halfwavelen = mItemWaveLen/2;
        path.moveTo(-mItemWaveLen+dx,originY);
        for(int i = -mItemWaveLen;i<=getWidth()+mItemWaveLen;i+=mItemWaveLen){
            path.rQuadTo(halfwavelen/2,-100,halfwavelen,0);
            path.rQuadTo(halfwavelen/2,100,halfwavelen,0);
        }
         path.lineTo(getWidth(),getHeight());
        path.lineTo(0,getHeight());
        path.close();
        canvas.drawPath(path, paint);

    }
    public void startAnimation(){
        ValueAnimator valueAnimator =  ValueAnimator.ofInt(0,mItemWaveLen);
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dx = (int)valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }
}
