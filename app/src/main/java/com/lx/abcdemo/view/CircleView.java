package com.lx.abcdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.lx.abcdemo.R;

public class CircleView extends View {

    private Paint paint;
    private int color;
    private float x;
    public CircleView(Context context) {
        this(context,null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint =new Paint();
        paint.setAntiAlias(true);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        color = array.getColor(R.styleable.CircleView_color,context.getResources().getColor(R.color.colorGro));
        array.recycle();
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        x = getWidth();
        paint.setColor(color);
        canvas.drawCircle(x/2,x/2,x/2,paint);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
