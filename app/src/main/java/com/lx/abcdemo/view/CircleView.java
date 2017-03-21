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
    private float x=18,y=18,r=18;

    public CircleView(Context context) {
        this(context,null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        color = array.getColor(R.styleable.CircleView_color,context.getResources().getColor(R.color.colorGro));
        array.recycle();
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle(x,y,r,paint);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
