package xiaoheihei.example.com.beisaierquxiantest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by xhh on 2017/10/11.
 */

public class MyPaintView extends View {
    private float downX;
    private float downY;
    private float upX;
    private float upY;

    private Path path = new Path();

    public MyPaintView(Context context) {
        super(context);
    }

    public MyPaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                path.moveTo(event.getX(), event.getY());
                downX =  event.getX();
                downY =  event.getY();

                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                path.lineTo(event.getX(), event.getY());
                float endX = (downX+event.getX())/2;
                float endY = (downY+event.getY())/2;
                path.quadTo(downX,downY,endX,endY);
                downX = event.getX();
                downY =event.getY();
                invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:{
                upX =  event.getX();
                upY =  event.getY();
                break;
            }
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint  =  new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        //绘制路径
        canvas.drawPath(path,paint);
        //通过两个点的坐标绘制矩形
        //canvas.drawRect(downX,downY,upX,upY,paint);
    }
    public void reset(){
        path.reset();
        postInvalidate();
    }
}
